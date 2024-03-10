package edu.steria.training;

public class Item {
    private String item_name;
    private double price;
    private  String type;
    public Item()
    {
    }
    public Item(String item_name, double price, String type) {
        this.item_name = item_name;
        this.price = price;
        this.type = type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
