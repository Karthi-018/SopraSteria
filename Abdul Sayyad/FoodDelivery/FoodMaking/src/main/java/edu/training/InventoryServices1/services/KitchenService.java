package edu.training.InventoryServices1.services;

import edu.training.InventoryServices1.dto.KitchenRequest;
import edu.training.InventoryServices1.dto.KitchenResponse;
import edu.training.InventoryServices1.models.Kitchen;
import edu.training.InventoryServices1.repo.KitchenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenService {
    private final KitchenRepo repo;
    public void createKitchenService(KitchenRequest kitchenRequest){
        Kitchen kitchen = new Kitchen();
        kitchen.setFoodName(kitchenRequest.getFoodName());
        kitchen.setFoodQuant(kitchenRequest.getFoodQuant());
        repo.save(kitchen);
    }

    public List<KitchenResponse> getKitchenStatus(List<String> foodNames){
        List<Kitchen> kitchenList = repo.findAll();
        List<KitchenResponse> kitchenResponseList = new ArrayList<>();
        for(Kitchen kitchen:kitchenList){
            for(String foodName:foodNames){
                if(kitchen.getFoodName().equals(foodName)){
                    if(kitchen.getFoodQuant()>0){
                        KitchenResponse kitchenResponse = new KitchenResponse();
                        kitchenResponse.setFoodName(foodName);
                        kitchenResponse.setFoodAvailability(true);
                        kitchenResponseList.add(kitchenResponse);
                    }
                    else{
                        KitchenResponse kitchenResponse = new KitchenResponse();
                        kitchenResponse.setFoodName(foodName);
                        kitchenResponse.setFoodAvailability(false);
                        kitchenResponseList.add(kitchenResponse);
                    }
                }
            }
        }
        return kitchenResponseList;
    }
}
