package edu.training.ProductServices1.controllers;

import edu.training.ProductServices1.dto.ProductRequest;
import edu.training.ProductServices1.dto.ProductResponse;
import edu.training.ProductServices1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        service.createProductService(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductList(){

        return service.getAllProductsService();
    }

}
