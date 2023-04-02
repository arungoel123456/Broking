package com.demo.dto;

public class PortfolioStock {
    private int quantity;
    private double averagePrice;

    public PortfolioStock(int quantity, double averagePrice) {
        this.quantity = quantity;
        this.averagePrice = averagePrice;
    }

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
