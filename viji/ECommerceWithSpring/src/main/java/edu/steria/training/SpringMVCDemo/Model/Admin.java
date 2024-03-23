package edu.steria.training.SpringMVCDemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String name;
	String username;
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin()
	{
		
	}
	public Admin(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	

}
