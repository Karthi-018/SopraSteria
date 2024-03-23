package edu.training.OrderServices1.controller;

import edu.training.OrderServices1.dto.OrderRequest;
import edu.training.OrderServices1.dto.OrderResponse;
import edu.training.OrderServices1.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequest orderRequest){
     service.createOrder(orderRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrderDetails(){
        return service.getOrderDetails();
    }
}
