package org.example;
public class Product_POJO {
    private int product_id;
    private String product_name;
    private int cost;
    private int quantity;
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

    public Product_POJO(int product_id, String product_name, int cost, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.cost = cost;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                " " + product_name +
                "          " + quantity +
                "        " + cost ;

    }
}