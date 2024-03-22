package edu.sopra.training.Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class WishList {
	
	private String username;
	private int pid;
	private String pname;
	private int price;
	@Id
	@GeneratedValue
	private int wishId;
	
	public String getUserNmae() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "WishList [username=" + username + ", pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	public WishList(String username, int pid, String pname, int price) {
		super();
		this.username = username;
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	public WishList() {
		super();
	}
	
	
	

}
