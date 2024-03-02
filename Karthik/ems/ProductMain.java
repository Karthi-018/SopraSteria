package edu.training.ems;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Product samsung = new Product(1,"Samsung","Smart Phone",15000);
        Product mi = new Product(2,"MI","Smart Phone",12000);
        Product oneplus = new Product(3,"OnePlus","Smart Phone",25000);
        Product motorola = new Product(4,"Motorola","Smart Phone",13000);

        ProductService ps = new ProductService();
        ps.addProduct(samsung);
        ps.addProduct(mi);
        ps.addProduct(oneplus);
        ps.addProduct(motorola);

        System.out.println("Product Listing");
        ps.listProducts();

        System.out.println("Editing Product Detsils");
        ps.editProduct("MI",14000);

        System.out.println("Searching Product ");
        ps.searchProduct("OnePlus");

    }
}
