package com.demo;

import com.demo.dto.*;

import java.util.*;

public class StockExchange {
    private static StockExchange stockExchangeInstance = null;

    private StockExchange() { }

    public synchronized static StockExchange getInstance() // this is synchronized as if 2 entities demand for its instance at the same time.
    {
        if(stockExchangeInstance == null) {
            stockExchangeInstance = new StockExchange();
        }
        return stockExchangeInstance;
    }
    public static boolean placeOrder(Order order) {
        boolean returnStatus = getInstance().submitOrder(order);
        return returnStatus;
    }

    public static Map<String, Stock> fetchPrices() {
        return new HashMap<>();
    }

    public boolean submitOrder(Order order){
        // this will depend on the stock exchange completely.
        return true;
    }

    public void placeBuyOrder(Order currentOrder, double v) {
    }

    public void placeSellOrder(Order currentOrder) {
    }
    public void placeOrder(List<Order> orders){

    }
}
