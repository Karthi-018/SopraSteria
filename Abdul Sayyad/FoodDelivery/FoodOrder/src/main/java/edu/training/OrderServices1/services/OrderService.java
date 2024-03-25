package edu.training.OrderServices1.services;

import edu.training.OrderServices1.dto.FoodDetailsDto;
import edu.training.OrderServices1.dto.KitchenResponse;
import edu.training.OrderServices1.dto.OrderRequest;
import edu.training.OrderServices1.dto.OrderResponse;
import edu.training.OrderServices1.model.FoodDetails;
import edu.training.OrderServices1.model.Orders;
import edu.training.OrderServices1.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
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

    private final WebClient webClient;
    public void createOrder(OrderRequest orderRequest){
        List<FoodDetails> foodDetailsList = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();
        for(FoodDetailsDto foodDetailsDto:orderRequest.getFoodDetailsDtoList()){
            FoodDetails foodDetails = new FoodDetails();
            foodDetails.setFoodName(foodDetailsDto.getFoodName());
            foodDetails.setFoodPrice(foodDetailsDto.getFoodPrice());
            foodDetailsList.add(foodDetails);
            foodNames.add(foodDetailsDto.getFoodName());
        }

        Orders order = new Orders();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setFoodDetailsList(foodDetailsList);

        KitchenResponse[] kitchenResponses = webClient.get().
                uri("http://localhost:9093/api/kitchen",uriBuilder -> uriBuilder.queryParam("foodNames",foodNames).build())
                .retrieve().bodyToMono(KitchenResponse[].class).block();

        boolean orderStatus = Arrays.stream(kitchenResponses).allMatch(status -> status.isFoodAvailability());
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
            List<FoodDetailsDto> foodDetailsDtoList = new ArrayList<>();
            for(FoodDetails foodDetails:order.getFoodDetailsList()){
                FoodDetailsDto foodDetailsDto = new FoodDetailsDto();
                foodDetailsDto.setFoodName(foodDetails.getFoodName());
                foodDetailsDto.setFoodPrice(foodDetails.getFoodPrice());
                foodDetailsDtoList.add(foodDetailsDto);
            }
            orderResponse.setFoodDetailsDtoList(foodDetailsDtoList);
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }
}
