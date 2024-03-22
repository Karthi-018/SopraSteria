package edu.sopra.training.Ecommerce.model;

import jakarta.persistence.*;


@Entity
public class Admin_1 {
	@Id
	private String adminName;
	private String adminPass;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public Admin_1() {
		super();
	}
	@Override
	public String toString() {
		return "Admin_1 [adminName=" + adminName + ", adminPass=" + adminPass + "]";
	}
	
	
}
