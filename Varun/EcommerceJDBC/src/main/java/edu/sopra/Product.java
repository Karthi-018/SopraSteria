package edu.sopra;
import java.util.*;
public class Product {
    private String pname;
    private String pdescription;
    private int pprice;
    private int quantity;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pname='" + pname + '\'' +
                ", pdescription='" + pdescription + '\'' +
                ", pprice=" + pprice +
                ", quantity=" + quantity +
                '}';
    }
}
