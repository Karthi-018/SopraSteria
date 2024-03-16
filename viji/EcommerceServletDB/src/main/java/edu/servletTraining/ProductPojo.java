package edu.servletTraining;

public class ProductPojo {
	private String name;
	private int id;
	private String description;
	private double price;
	private int quantity;
	
	ProductPojo()
	{
		
	}

	ProductPojo(int id,String name,String desc,double price,int quantity )
	{
		this.id=id;
		this.name=name;
		this.description=desc;
		this.price=price;
		this.quantity=quantity;
	}
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}
	public String getDesc()
	{
		return description;
	}
	public double  getPrice()
	{
		return price;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
