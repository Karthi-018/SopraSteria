package edu.sopra.training.SpringBootMVC.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cid;
	private String email;
	private int productId;
	private int quantity;
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
	@Override
	public String toString() {
		return "Cart [email=" + email + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
