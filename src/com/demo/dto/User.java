package com.demo.dto;

import java.util.*;
import java.util.stream.*;

public class User {
    private String id;
    private String name;
    private double fund;
    private List<Stock> watchList;
    private Portfolio portfolio;
    private Map<String, Order> activeOrders;

    public User(String name) {
        this.name = name;
        fund=0;
        watchList= new ArrayList<>();
        portfolio= new Portfolio(name);
        activeOrders= new HashMap<>();
    }

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
    public void changeFund(double change){
        this.fund+= change;
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
    public boolean checkFund(double amount){
        return amount<=fund;
    }
    public boolean checkStockInPortfolio(String stockId, int qty)
    {
        Stock s= watchList.stream().filter( stock -> stock.getId().equals(stockId)).collect(Collectors.toList()).get(0);

        return portfolio.checkIfPresent(s, qty);
    }
    public void changePortfolio(Order order){
        Stock s= watchList.stream().filter( stock -> stock.getId().equals(order.getStockId())).collect(Collectors.toList()).get(0);
        this.portfolio.changePortfolio(order, s);
    }
}
