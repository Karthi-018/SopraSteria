package edu.training.InventoryServices1.controllers;

import edu.training.InventoryServices1.dto.InventoryRequest;
import edu.training.InventoryServices1.dto.InventoryResponse;
import edu.training.InventoryServices1.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryRequest inventoryRequest){
        service.createInventoryService(inventoryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getProductStatus(@RequestParam List<String> productNames){
        return service.getInventoryStatus(productNames);
    }

}
