package edu.training.HibMappingDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	private int bid;
	private String bookName;
	@ManyToMany
	private List<Student> student = new ArrayList<>();
	public Book(int bid, String bookName) {
		super();
		this.bid = bid;
		this.bookName = bookName;
	}
	public Book() {
		super();
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookName=" + bookName + "]";
	}
	

}
