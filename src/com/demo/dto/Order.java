package com.demo.dto;

import com.demo.enums.*;
import com.demo.orderState.*;

public class Order {
    private String stockId;
    public OrderType orderType;
    private int qty;
    public boolean isLimitOrder; // type
    private double price;
    private User user;
    private OrderState orderState;

    public Order(String stockId, OrderType orderType, int qty, boolean isLimitOrder, User user) {
        this.stockId = stockId;
        this.orderType = orderType;
        this.qty = qty;
        this.isLimitOrder = isLimitOrder;
        this.user = user;
        this.orderState= new OrderInProgress();
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isLimitOrder() {
        return isLimitOrder;
    }

    public void setLimitOrder(boolean limitOrder) {
        isLimitOrder = limitOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
    public void notify(ErrorCode errorCode){
        this.orderState.notifyUsers(user, errorCode);
    }
}
