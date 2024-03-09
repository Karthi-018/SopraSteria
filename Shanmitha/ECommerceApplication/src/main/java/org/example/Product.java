package org.example;

public class Product {

    private String productName;
    //private String productDesc;
    private int price;
    private int quantity;

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getProductDesc() {
//        return productDesc;
//    }
//
//    public void setProductDesc(String productDesc) {
//        this.productDesc = productDesc;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
