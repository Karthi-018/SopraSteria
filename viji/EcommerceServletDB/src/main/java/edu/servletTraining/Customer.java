package edu.servletTraining;

public class Customer {
private String firstName;
private String LastName;
private String email;
private String password;
private String dob;
private String gender;
private String status;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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

public Customer(String firstName, String lastName, String email, String password, String dob, String gender,
		String status) {
	super();
	this.firstName = firstName;
	LastName = lastName;
	this.email = email;
	this.password = password;
	this.dob = dob;
	this.gender = gender;
	this.status = status;
}

}
