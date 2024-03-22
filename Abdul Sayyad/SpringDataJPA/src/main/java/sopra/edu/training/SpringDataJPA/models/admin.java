package sopra.edu.training.SpringDataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class admin {
@Id
private String uname;
private String passw;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassw() {
	return passw;
}
public void setPassw(String passw) {
	this.passw = passw;
}


}
