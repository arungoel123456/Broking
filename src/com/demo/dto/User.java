package com.demo.dto;

import java.util.*;

public class User {
    private String id;
    private String name;
    private double fund;
    private List<Stock> watchList;
    private Portfolio portfolio;
    private Map<String, Order> activeOrders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public List<Stock> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<Stock> watchList) {
        this.watchList = watchList;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Map<String, Order> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(Map<String, Order> activeOrders) {
        this.activeOrders = activeOrders;
    }
}
