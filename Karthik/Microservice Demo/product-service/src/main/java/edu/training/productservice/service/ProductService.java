package edu.training.productservice.service;

import edu.training.productservice.dto.ProductRequest;
import edu.training.productservice.dto.ProductResponce;
import edu.training.productservice.model.Products;
import edu.training.productservice.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo repo;

    public void createProduct(ProductRequest productRequest)
    {
//        Products products = Products.builder()
//                .productName(productRequest.getProductName())
//                .productDesc(productRequest.getProductDesc())
//                .productPrice(productRequest.getProductPrice())
//                .build();

        Products products = new Products();
        products.setProductName(productRequest.getProductName());
        products.setProductDesc(productRequest.getProductDesc());
        products.setProductPrice(productRequest.getProductPrice());
        repo.save(products);
    }


    public List<ProductResponce> getAllProducts()
    {
        List<Products> products = repo.findAll();

        ProductResponce pr = null;
        List<ProductResponce> productResponces = new ArrayList<>();
        for(Products p : products)
        {
             pr = new ProductResponce();
            pr.setProductName(p.getProductName());
            pr.setProductDesc(p.getProductDesc());
            pr.setProductPrice(p.getProductPrice());
            productResponces.add(pr);
        }



//      List<ProductResponce> productResponces =  products.stream().map(product->mapToProductResponce(product)).toList();
        return productResponces;
    }

    private ProductResponce mapToProductResponce(Products product) {

      return  ProductResponce.builder()
                .proId(product.getProId())
                .productName(product.getProductName())
                .productDesc(product.getProductDesc())
                .productPrice(product.getProductPrice())
                .build();
    }


}
