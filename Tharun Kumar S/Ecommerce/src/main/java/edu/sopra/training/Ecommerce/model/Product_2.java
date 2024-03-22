package edu.sopra.training.Ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Product_2 {
	@Id
	private int pid;
	private String pname;
	private String descp;
	private int quan;
	private int price;
	
	

	public Product_2() {
		super();
	}
	@Override
	public String toString() {
		return "Product_2 [pid=" + pid + ", pname=" + pname + ", descp=" + descp + ", quan=" + quan + ", price=" + price
				+ "]";
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
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product_2(int pid, String pname, String descp, int quan, int price) {
		this.pid = pid;
		this.pname = pname;
		this.descp = descp;
		this.quan = quan;
		this.price = price;
	}
	

	}
	
	
	
	

	


