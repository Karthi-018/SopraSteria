package edu.training.OrderServices1.services;

import edu.training.OrderServices1.dto.InventoryResponse;
import edu.training.OrderServices1.dto.OrderRequest;
import edu.training.OrderServices1.dto.OrderResponse;
import edu.training.OrderServices1.dto.ProductDetailsDto;
import edu.training.OrderServices1.model.Orders;
import edu.training.OrderServices1.model.ProductDetails;
import edu.training.OrderServices1.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;

    private final WebClient.Builder webClient;
    public void createOrder(OrderRequest orderRequest){
        List<ProductDetails> productDetailsList = new ArrayList<>();
        List<String> productNames = new ArrayList<>();
        for(ProductDetailsDto productDetailsDto:orderRequest.getProductDetailsDtoList()){
            ProductDetails productDetails = new ProductDetails();
            productDetails.setProductName(productDetailsDto.getProductName());
            productDetails.setProductPrice(productDetailsDto.getProductPrice());
            productDetails.setProductQuant(productDetailsDto.getProductQuant());
            productDetailsList.add(productDetails);
            productNames.add(productDetailsDto.getProductName());
        }

        Orders order = new Orders();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setProductDetailsList(productDetailsList);

        InventoryResponse[] inventoryResponses = webClient.build().get().
                uri("lb://InventoryServices1/api/inventory",uriBuilder -> uriBuilder.queryParam("productNames",productNames).build())
                .retrieve().bodyToMono(InventoryResponse[].class).block();
        boolean orderStatus = Arrays.stream(inventoryResponses).allMatch(status -> status.isProductAvailability());
        if(orderStatus) {
            orderRepo.save(order);
        }
        else{
            throw new IllegalArgumentException("some of the Products are out of stock");
        }
    }

    public List<OrderResponse> getOrderDetails(){
        List<Orders> ordersList=orderRepo.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for(Orders order : ordersList){
            OrderResponse orderResponse = new OrderResponse();
            List<ProductDetailsDto> productDetailsDtoList = new ArrayList<>();
            for(ProductDetails productDetails:order.getProductDetailsList()){
                ProductDetailsDto productDetailsDto = new ProductDetailsDto();
                productDetailsDto.setProductName(productDetails.getProductName());
                productDetailsDto.setProductQuant(productDetails.getProductQuant());
                productDetailsDto.setProductPrice(productDetails.getProductPrice());
                productDetailsDtoList.add(productDetailsDto);
            }
            orderResponse.setProductDetailsDtoList(productDetailsDtoList);
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }
}
