package com.demo.services;

import com.demo.dto.*;

import java.util.*;

public class StockServiceImpl {
    private Map<String, Stock> stockList;
    private static StockServiceImpl stockServiceImpl= null;

    private StockServiceImpl() {
        this.stockList = new HashMap<>();
    }

    public static StockServiceImpl getInstance(){
        if(stockServiceImpl== null){
            stockServiceImpl= new StockServiceImpl();
        }
        return stockServiceImpl;
    }

    public int getStockPrice(String stockId){
        return stockList.get(stockId).getPrice();
    }
    public void setStockPrice(String stockId, int price) {
        Stock stock= stockList.get(stockId);
        stock.setPrice(price);
    }
    public Stock addStock(String id, int price){
        Stock s= new Stock(id,price);
        stockList.put(id, s);
        return s;
    }
}
