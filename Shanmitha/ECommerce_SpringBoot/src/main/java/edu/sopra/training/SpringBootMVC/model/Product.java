package edu.sopra.training.SpringBootMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int pId;
	String name;
	String descr;
	int price;
	int quantity;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return descr;
	}
	public void setDesc(String descr) {
		this.descr = descr;
	}
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
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", desc=" + descr + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}
