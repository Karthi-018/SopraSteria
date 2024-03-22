package edu.training.inventoryservice.controller;

import edu.training.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String checkProductStock(@RequestParam String productName)
    {
      return   inventoryService.checkProductStock(productName);
    }
}
