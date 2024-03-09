package edu.training;

public class product{
private int productId;
private String productName;
private String productDesc;
private int productQuant;
private int productPrice;
product(){}

    public product(int productId, String productName, String productDesc, int productQuant, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productQuant = productQuant;
        this.productPrice = productPrice;
        
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductQuant() {
        return productQuant;
    }

    public void setProductQuant(int productQuant) {
        this.productQuant = productQuant;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

   
}
