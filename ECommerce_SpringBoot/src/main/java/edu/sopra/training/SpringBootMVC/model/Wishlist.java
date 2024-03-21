package edu.sopra.training.SpringBootMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int wishId;
	String email;
	String prodName;
	int productId;
	int quantity;
	int price;
	public int getWishId() {
		return wishId;
	}
	public void setWishId(int wishId) {
		this.wishId = wishId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
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
	@Override
	public String toString() {
		return "Wishlist [wishId=" + wishId + ", email=" + email + ", prodName=" + prodName + ", productId=" + productId
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	

}
