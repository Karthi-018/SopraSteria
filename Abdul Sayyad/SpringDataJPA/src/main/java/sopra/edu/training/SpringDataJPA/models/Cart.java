package sopra.edu.training.SpringDataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int cid;
private String userEmail;
private int pId;
private int quantity;

public Cart() {
	super();
}
public Cart(int cid, String userEmail, int pId, int quantity) {
	super();
	this.cid = cid;
	this.userEmail = userEmail;
	this.pId = pId;
	this.quantity = quantity;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
