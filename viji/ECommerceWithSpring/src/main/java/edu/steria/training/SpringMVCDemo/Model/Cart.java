package edu.steria.training.SpringMVCDemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;	
private int productId;
private String productName;
private String descrption;
private double price;
private String username;
private int pQuantity;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public int getpQuantity() {
	return pQuantity;
}
public void setpQuantity(int pQuantity) {
	this.pQuantity = pQuantity;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescrption() {
	return descrption;
}
public void setDescrption(String descrption) {
	this.descrption = descrption;
}

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Cart()
{
	
}
public Cart(int productId, String productName, String descrption, double price, String username, int pQuantity) {
	
	this.productId = productId;
	this.productName = productName;
	this.descrption = descrption;
	this.price = price;
	this.username = username;
	this.pQuantity = pQuantity;
}





}
