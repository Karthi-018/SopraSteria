package training;

public class pojo {

		private int id;
	    private String name;
	    private String desc;
	    private int price;
	    private int qty;

	    public pojo(int id,String name,String desc,int price,int qty) {
	    	this.id=id;
	        this.name = name;
	        this.desc=desc;
	        this.price = price;
	        this.qty=qty;
	    }
	    
	    
	    
	    public pojo(int id, String name, String desc, int price) {
			super();
			this.id = id;
			this.name = name;
			this.desc = desc;
			this.price = price;
		}



		public pojo(int id, String name, int price, int qty) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.qty = qty;
		}



		public pojo(String name, String desc, int price) {
			super();
			this.name = name;
			this.desc = desc;
			this.price = price;
		}



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

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }
	    
	    public String getDesc() {
	        return desc;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }

	    public int getQty() {
	        return qty;
	    }

	    public void setType(int qty) {
	        this.qty =qty;
	    }

	    @Override
	    public String toString() {
	        return "pojo{" +
	        		"id=" + id + 
	                ", name='" + name + '\'' +
	                ", desc='" + desc + '\'' +
	                ", price=" + price +
	                ", qty=" + qty +
	                '}';
	    }


	


}
