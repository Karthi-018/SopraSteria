package edu.sopra.training.SpringBootMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
int cartId;
String email;
String prodName;
int productId;
int quantity;
int price;

public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", email=" + email + ", prodName=" + prodName + ", productId=" + productId
			+ ", quantity=" + quantity + ", price=" + price + "]";
}


}
