package edu.sopra.training.Ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Cust_2 {
	
	private String fname;
	private String lname;
	private String email;
	
	@Id
	private String userName;
	
	private String password;
	private String dob;
	private String gender;
	private String status;
	private int jo;
	
	
	public Cust_2() {
		super();
	}
	public Cust_2(String fname, String lname, String email, String userName, String password, String dob, String gender,
			String status,int jo) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
		this.jo=jo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getJo() {
		return jo;
	}
	public void setJo(int jo) {
		this.jo = jo;
	}
	
	@Override
	public String toString() {
		return "Cust_2 [fname=" + fname + ", lname=" + lname + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", status=" + status + "]";
	}
	
	
	
	

}
