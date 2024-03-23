package edu.steria.training.SpringMVCDemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WishList {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;
private int productId;
private String uname;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public WishList(int productId, String uname) {
	super();
	this.productId = productId;
	this.uname = uname;
}
public WishList()
{
	
}
}
