package sopra.edu.training.SpringDataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	private String userEmail;
	private String first_name;
	private String last_name;
	private String userPassWord;
	private String userDOB;
	private String userGender;
	private String access = "New";
	
	public Customer() {
		super();
	}
	public Customer(String userEmail, String first_name, String last_name, String userPassWord, String userDOB,
			String userGender) {
		super();
		this.userEmail = userEmail;
		this.first_name = first_name;
		this.last_name = last_name;
		this.userPassWord = userPassWord;
		this.userDOB = userDOB;
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public String getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	

}
