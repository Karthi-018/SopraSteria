package Ecommerce;

public class ProductDAO {
    private int pid;
    private String pname;
    private int cost;
    private int quantity;

    public ProductDAO(int pid, String pname, int cost, int quantity) {
        this.pid = pid;
        this.pname = pname;
        this.cost = cost;
        this.quantity = quantity;
    }

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product { " +
                "pid = " + pid +
                " , pname = '" + pname + '\'' +
                " , cost = " + cost +
                " , quantity = " + quantity +
                " }";
    }
}
