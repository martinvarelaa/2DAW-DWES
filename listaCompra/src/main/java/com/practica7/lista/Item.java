package com.practica7.lista;

public class Item {
    private int ID;
    private String name;
    private String description;
    private int price;
    private boolean bought;

    public Item(int ID, String name, String description, int price, boolean bought) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.bought = bought;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

}
