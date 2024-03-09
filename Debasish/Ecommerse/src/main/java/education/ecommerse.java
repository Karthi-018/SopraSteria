package education;

public class ecommerse {
	private int pId;
	private String pName;
	private String pDesc;
	private int	   pPrice;
	private int    pQuantity;
	
	
	public ecommerse(int pId, String pName, String pDesc, int pPrice, int pQuantity) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pQuantity = pQuantity;
	}
	
	@Override
	public String toString() {
		return "ecommerse [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPrice=" + pPrice + ", pQuantity="
				+ pQuantity + "]";
	}


	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	
	
	

}
