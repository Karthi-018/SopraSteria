package sopra.edu.training.SpringDataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
public class Product {
	@Id
private int pId;
private String productName;
private String productDesc;
private int productQuant;
private int productPrice;

public Product() {
	super();
}
public Product(int pId, String productName, String productDesc, int productQuant, int productPrice) {
	super();
	this.pId = pId;
	this.productName = productName;
	this.productDesc = productDesc;
	this.productQuant = productQuant;
	this.productPrice = productPrice;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
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
@Override
public String toString() {
	return "Product [pId=" + pId + ", productName=" + productName + ", productDesc=" + productDesc + ", productQuant="
			+ productQuant + ", productPrice=" + productPrice + "]";
}

}
