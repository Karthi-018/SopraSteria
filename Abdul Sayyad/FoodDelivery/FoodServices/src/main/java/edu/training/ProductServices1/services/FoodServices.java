package edu.training.ProductServices1.services;

import edu.training.ProductServices1.dto.FoodRequest;
import edu.training.ProductServices1.dto.FoodResponse;

import edu.training.ProductServices1.dto.KitchenRequest;
import edu.training.ProductServices1.models.Food;
import edu.training.ProductServices1.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServices {
    private final FoodRepo repo;
    private final WebClient webClient;
    public void createProductService(FoodRequest foodRequest){


        Food food = new Food();
        food.setFoodName(foodRequest.getFoodName());
        food.setFoodDesc(foodRequest.getFoodDesc());
        food.setFoodPrice(foodRequest.getFoodPrice());
        food.setFoodQuant(foodRequest.getFoodQuant());



        KitchenRequest kitchenRequest = new KitchenRequest();
         kitchenRequest.setFoodName(foodRequest.getFoodName());
        kitchenRequest.setFoodQuant(foodRequest.getFoodQuant());

        webClient.post().uri("http://localhost:9093/api/kitchen")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(kitchenRequest)
                .retrieve().toBodilessEntity().block();
        repo.save(food);


    }


    public List<FoodResponse> getAllFoodService(){
        List<Food> menu = repo.findAll();
        List<FoodResponse> foodResponseList = new ArrayList<>();
        for(Food food:menu){
            FoodResponse foodResponse = new FoodResponse();
            foodResponse.setFoodName(food.getFoodName());
            foodResponse.setFoodDesc(food.getFoodDesc());
            foodResponse.setFoodPrice(food.getFoodPrice());
            foodResponse.setFoodQuant(food.getFoodQuant());

            foodResponse.setFoodId(food.getFoodId());
            foodResponseList.add(foodResponse);
        }
        return foodResponseList;
    }
}
