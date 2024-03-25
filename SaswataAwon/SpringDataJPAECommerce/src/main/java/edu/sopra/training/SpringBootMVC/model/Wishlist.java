package edu.sopra.training.SpringBootMVC.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int wid;
	private String email;
	private int productId;
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
	@Override
	public String toString() {
		return "Wishlist [wid=" + wid + ", email=" + email + ", productId=" + productId + "]";
	}
	
	
}
