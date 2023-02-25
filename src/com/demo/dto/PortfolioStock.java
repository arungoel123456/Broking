package com.demo.dto;

public class PortfolioStock {
    private int quantity;
    private double averagePrice;

    public void changeQuantity(int quantity){
        this.quantity += quantity;
        return;
    }

    public void changeAvg(int qty, double purchasePrice){
        averagePrice= ((quantity*averagePrice) + (qty*purchasePrice))/(qty+quantity);
    }
    public int getQuantity(){
        return this.quantity;
    }
}
