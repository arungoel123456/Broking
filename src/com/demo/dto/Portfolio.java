package com.demo.dto;

import com.demo.enums.*;

import java.util.*;

public class Portfolio {
    private String userId;
    private Map<Stock, PortfolioStock> portfolio;

    public Portfolio(String userId) {
        this.userId = userId;
        portfolio= new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Stock, PortfolioStock> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Map<Stock, PortfolioStock> portfolio) {
        this.portfolio = portfolio;
    }

    public void addStockInPortfolio(Order order, Stock s){
        this.portfolio.put( s, new PortfolioStock(order.getQty(), order.getPrice() ) );
    }

    public boolean checkIfPresent(Stock stockId, int qty) {
        if (portfolio.containsKey(stockId)) {
            return portfolio.get(stockId).getQuantity() >= qty;

        } else {
            return false;
        }
    }

    public void changePortfolio(Order order, Stock stock) {
        PortfolioStock portfolioStock = portfolio.get(stock);
        if(portfolioStock==null){
            portfolioStock= new PortfolioStock(0,0);
            portfolio.put(stock, portfolioStock);
        }
        if (order.orderType == OrderType.BUY) {
            portfolioStock.changeAvg(order.getQty(), order.getPrice());
            portfolioStock.changeQuantity(order.getQty());
        } else {
            portfolioStock.changeQuantity(order.getQty() * (-1));
        }
    }
}
