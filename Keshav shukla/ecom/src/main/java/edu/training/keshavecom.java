package edu.training;

public class keshavecom {
	String productname;
	int productprice;
	int productid;
	String productdesc;
	int productquantity;
	public keshavecom(String productname,int productprice,int productid,String productdesc,int productquantity){
		this.productname=productname;
		this.productid=productid;
		this.productdesc=productdesc;
		this.productprice=productprice;
		this.productquantity=productquantity;
	}
	public String getproductname() {
		return productname;
	}
	public int getproductprice() {
		return productprice;
	}
	public int getproductid() {
		return productid;
	}
	public String getproductdesc() {
		return productdesc;
	}
	public int productquantity() {
		return productquantity;
	}
	public void setproductname(String productname) {
		this.productname=productname;
	}
	public void setproductid(int productid) {
		this.productid=productid;
	}
	public void setproductdesc(String productdesc) {
		this.productdesc=productdesc;
	}
	public void setproductprice(int productprice) {
		this.productprice=productprice;
	}
	public void setproductquantity(int productquantity) {
		this.productquantity=productquantity;
	}
	@Override
    public String toString() {
        return "keshavecom{" +
                "productname='" + productname + '\'' +
                ", productprice='" + productprice+ '\'' +
                ", productdesc=" + productdesc +
                ", productquantity=" + productquantity +
                ", productid" +productid+
                '}';
    }
	
	

}
