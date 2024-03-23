package edu.training.ProductServices1.services;

import edu.training.ProductServices1.dto.InventoryRequest;
import edu.training.ProductServices1.dto.ProductRequest;
import edu.training.ProductServices1.dto.ProductResponse;
import edu.training.ProductServices1.models.Product;
import edu.training.ProductServices1.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;
    private final WebClient webClient;
    public void createProductService(ProductRequest productRequest){


        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductDesc(productRequest.getProductDesc());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductQuant(productRequest.getProductQuant());


        InventoryRequest inventoryRequest = new InventoryRequest();
        inventoryRequest.setProductName(productRequest.getProductName());
        inventoryRequest.setProductQuant(productRequest.getProductQuant());

        webClient.post().uri("http://localhost:9093/api/inventory")
                .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(inventoryRequest)
                                .retrieve().toBodilessEntity().block();
        repo.save(product);


    }


    public List<ProductResponse> getAllProductsService(){
        List<Product> products = repo.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Product product:products){
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductName(product.getProductName());
            productResponse.setProductDesc(product.getProductDesc());
            productResponse.setProductPrice(product.getProductPrice());
            productResponse.setProId(product.getProId());
            productResponse.setProductQuant(product.getProductQuant());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }
}
