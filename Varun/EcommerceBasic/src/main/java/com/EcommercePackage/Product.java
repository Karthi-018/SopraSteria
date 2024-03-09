package com.EcommercePackage;

public class Product {
	
	
	
	
    private String pname;
    private String pdescription;
    private int pprice;
    private int pquantity;

    
    
    public Product(String name,String description,int price,int quantity)
    {
    	this.pname=name;
    	this.pdescription=description;
    	this.pprice=price;
    	this.pquantity=quantity;
    }
    
    
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public int getPquantity() {
        return pquantity;
    }

    public void setQuantity(int quantity) {
        this.pquantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pname='" + pname + '\'' +
                ", pdescription='" + pdescription + '\'' +
                ", pprice=" + pprice +
                ", quantity=" + pquantity +
                '}';
    }
}