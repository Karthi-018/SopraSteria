package edu.training.ProductServices1.controllers;

import edu.training.ProductServices1.dto.FoodRequest;
import edu.training.ProductServices1.dto.FoodResponse;

import edu.training.ProductServices1.services.FoodServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodServices service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody FoodRequest foodRequest){
        service.createProductService(foodRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FoodResponse> getProductList(){

        return service.getAllFoodService();
    }

}
