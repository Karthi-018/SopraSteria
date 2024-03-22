package edu.sopra.training.Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cart_1 {
	
	private String user;
	private int pid;
	private String pname;
	private String descp;
	private int quant;
	private int price;
	@Id
	@GeneratedValue
	private int cartId;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	@Override
	public String toString() {
		return "Cart_1 [user=" + user + ", pid=" + pid + ", pname=" + pname + ", descp=" + descp + ", quant=" + quant
				+ ", price=" + price + "]";
	}
	public Cart_1(String user, int pid, String pname,String descp, int quant, int price) {
		super();
		this.user = user;
		this.pid = pid;
		this.pname = pname;
		this.descp = descp;
		this.quant = quant;
		this.price = price;
	}
	public Cart_1() {
		super();
	}
	

}
