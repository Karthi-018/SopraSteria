package edu.training.orderservice.service;

import edu.training.orderservice.dto.OderLineItemsDto;
import edu.training.orderservice.dto.OrderRequest;
import edu.training.orderservice.model.OderLineItems;
import edu.training.orderservice.model.Order;
import edu.training.orderservice.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    public void placeOrder(OrderRequest orderRequest)
    {
        List<OderLineItems> productList = orderRequest.getOderLineItemsList().stream().map(product->mapToOrderLineItems(product)).toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .oderLineItemsList(productList)
                .build();

        repo.save(order);

    }

    private OderLineItems mapToOrderLineItems(OderLineItemsDto o) {

        return OderLineItems.builder()
                .productName(o.getProductName())
                .productPrice(o.getProductPrice())
                .productQty(o.getProductQty())
                .build();
    }
}
