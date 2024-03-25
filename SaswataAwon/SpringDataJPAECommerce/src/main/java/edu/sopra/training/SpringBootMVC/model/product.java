package edu.sopra.training.SpringBootMVC.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pid;
	private String pname;
	private String pdesc;
	private int pprice;
	private int qty;
	@Lob
	private Blob imgpath;
	
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
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
//	public Blob getImgpath() {
//		return imgpath;
//	}
//	public void setImgpath(Blob imgpath) {
//		this.imgpath = imgpath;
//	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", pprice=" + pprice + ", qty=" + qty
				+ ", imgpath=" + imgpath + "]";
	}
	
	
	
	
}
