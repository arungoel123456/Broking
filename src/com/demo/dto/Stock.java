package com.demo.dto;

public class Stock {
    public String id;
    private int price;

    public Stock(String id, int price) {
        this.id = id;
        this.price = price;
    }


    public void setPrice(int price){
        this.price= price;
        return;
    }
    public int getPrice(){
        return this.price;
    }

    public String getId() {
        return this.id;
    }
}
