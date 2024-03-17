package action.training;

public class PCart {
	
	static String email;
	int id;
	int qty;
	
	public PCart(String email, int id, int qty) {
		super();
		this.email = email;
		this.id = id;
		this.qty = qty;
	}

	public PCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public PCart(int qty) {
		super();
		this.qty = qty;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "PCart [email=" + email + ", id=" + id + ", qty=" + qty + "]";
	}
	
	
	
	

}
