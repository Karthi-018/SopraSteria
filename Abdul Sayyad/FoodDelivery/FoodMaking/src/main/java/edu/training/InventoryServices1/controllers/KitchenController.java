package edu.training.InventoryServices1.controllers;

import edu.training.InventoryServices1.dto.KitchenRequest;
import edu.training.InventoryServices1.dto.KitchenResponse;
import edu.training.InventoryServices1.models.Kitchen;
import edu.training.InventoryServices1.services.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchen")
@RequiredArgsConstructor
public class KitchenController {
    private final KitchenService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createKitchen(@RequestBody KitchenRequest kitchenRequest){
        service.createKitchenService(kitchenRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<KitchenResponse> getfoodStatus(@RequestParam List<String> foodNames){
        return service.getKitchenStatus(foodNames);
    }

}
