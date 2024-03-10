package sopra.test;

public class Product {

    public int pid;
    public String pname;
    public String pdesc;
    public int price;
    public int pquant;

    public Product(int pid, String pname, String pdesc, int price, int pquant) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.price = price;
        this.pquant = pquant;
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

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPquant() {
        return pquant;
    }

    public void setPquant(int pquant) {
        this.pquant = pquant;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", price=" + price +
                ", pquant=" + pquant +
                '}';
    }
}
