package edu.training.InventoryServices1.services;

import edu.training.InventoryServices1.dto.InventoryRequest;
import edu.training.InventoryServices1.dto.InventoryResponse;
import edu.training.InventoryServices1.models.Inventory;
import edu.training.InventoryServices1.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo repo;
    public void createInventoryService(InventoryRequest inventoryRequest){
        Inventory inventory = new Inventory();
        inventory.setProductName(inventoryRequest.getProductName());
        inventory.setProductQuant(inventoryRequest.getProductQuant());
        repo.save(inventory);
    }

    public List<InventoryResponse> getInventoryStatus(List<String> productNames){
        List<Inventory> inventoryList = repo.findAll();
        List<InventoryResponse> inventoryResponseList = new ArrayList<>();
        for(Inventory inventory:inventoryList){
            for(String productName:productNames){
                if(inventory.getProductName().equals(productName)){
                    if(inventory.getProductQuant()>0){
                        InventoryResponse inventoryResponse = new InventoryResponse();
                        inventoryResponse.setProductName(productName);
                        inventoryResponse.setProductAvailability(true);
                        inventoryResponseList.add(inventoryResponse);
                    }
                    else{
                        InventoryResponse inventoryResponse = new InventoryResponse();
                        inventoryResponse.setProductName(productName);
                        inventoryResponse.setProductAvailability(false);
                        inventoryResponseList.add(inventoryResponse);
                    }
                }
            }
        }
        return inventoryResponseList;
    }
}
