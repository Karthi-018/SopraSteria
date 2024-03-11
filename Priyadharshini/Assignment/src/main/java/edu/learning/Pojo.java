package edu.learning;

public class Pojo {
    private int product_id;
    private String product_name;
    private String product_desc;
    private int product_price;
    private int product_qty;

    public Pojo(int product_id, String product_name, String product_desc, int product_price, int product_qty) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_price = product_price;
        this.product_qty = product_qty;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", product_price=" + product_price +
                ", product_qty=" + product_qty +
                '}';
    }
}
