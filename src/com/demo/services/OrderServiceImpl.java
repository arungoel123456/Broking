package com.demo.services;

import com.demo.*;
import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.order.*;
import com.demo.orderState.*;
import java.util.*;

public class OrderServiceImpl {

    OrderValidationEngine buyOrderValidationEngine;
    OrderValidationEngine sellOrderValidationEngine;
    StockExchange stockExchange= StockExchange.getInstance();
    StockServiceImpl stockServiceImpl= StockServiceImpl.getInstance();
    Map<String, List<Order>> limitOrders;
    private static OrderServiceImpl orderService= null;

    private OrderServiceImpl(){
        buyOrderValidationEngine= new OrderValidationEngine(new BuyValidationStrategy());
        sellOrderValidationEngine= new OrderValidationEngine(new SellValidationStrategy());
        limitOrders= new HashMap<>();
    }

    public static OrderServiceImpl getInstance(){
        if(orderService==null){
            orderService= new OrderServiceImpl();
        }
        return orderService;
    }

    public void placeMarketOrder(String stockId, int qty, OrderType orderType, User createdBy  ){
        Order marketOrder= new Order(stockId,orderType,qty, false, createdBy);
        int currentMarketPrice= stockServiceImpl.getStockPrice(marketOrder.getStockId());

        marketOrder.setPrice(currentMarketPrice);
        if(marketOrder.orderType == OrderType.BUY){
            placeBuyOrder(marketOrder);
        }
        else{
            placeSellOrder(marketOrder);
        }
    }

    private void placeBuyOrder(Order order){
        if( !buyOrderValidationEngine.validate(order) ){
            order.setOrderState(new OrderFailed());
            order.notify(ErrorCode.INSUFFICIENT_BALANCE);
        }
        else{
            executeBuyOrder(order);
            order.setOrderState(new OrderSuccessful());
            order.notify(ErrorCode.ORDER_SUCCESSFUL);
        }
    }

    private void placeSellOrder(Order order){
        if( !sellOrderValidationEngine.validate(order) )
        {
            order.setOrderState(new OrderFailed());
            order.notify(ErrorCode.NO_STOCK_POSITIONS);
        }
        else{
            executeSellOrder(order);
            order.setOrderState(new OrderSuccessful());
            order.notify(ErrorCode.ORDER_SUCCESSFUL);
        }
    }

    private void executeBuyOrder(Order currentOrder ){
        currentOrder.getUser().changeFund(currentOrder.getPrice()* currentOrder.getQty() * (-1));

        stockExchange.placeBuyOrder(currentOrder, currentOrder.getPrice()* currentOrder.getQty() ); // taking funds from the account.
        currentOrder.getUser().changePortfolio(currentOrder); // putting stocks in the portfolio
    }

    private void executeSellOrder(Order currentOrder){
        stockExchange.placeSellOrder(currentOrder);
        currentOrder.getUser().changeFund(currentOrder.getPrice()* currentOrder.getQty() );
        currentOrder.getUser().changePortfolio(currentOrder);
    }

    public void validateAndPlaceLimitOrders(List<Order> limitOrders){
        limitOrders.stream().parallel().forEach(currentOrder -> {
            if (currentOrder.getPrice() == stockServiceImpl.getStockPrice(currentOrder.getStockId()) ) {
                if (currentOrder.orderType == OrderType.BUY) {
                    placeBuyOrder(currentOrder);
                } else {
                    placeSellOrder(currentOrder);
                }
            }
        });
    }

    private int getIndex(String stockId, int price){
        return 0;
    }

    public void updateLimitOrders(String stockId, int price){
        synchronized (limitOrders.get(stockId)){
            // find the index for which has stock price equal and more than the current price.
            List<Order> limitOrdersForStock= limitOrders.get(stockId);
            int index= getIndex(stockId, price);
            List<Order> ordersToSendToMarket = limitOrdersForStock.subList(index, limitOrdersForStock.size());
            validateAndPlaceLimitOrders(ordersToSendToMarket);
            limitOrders.replace(stockId, limitOrdersForStock.subList(0,index) );
        }
    }


    public void createLimitOrder(String stockId, double price, int qty, OrderType orderType, User createdBy){
        Order limitOrder= new Order(stockId, orderType, qty, true, createdBy);
        limitOrder.setPrice(price);

        // we can think of better algorithm of adding limit order in the list at the right place.
        List<Order> limitOrdersList=  limitOrders.get(stockId);
        if(limitOrdersList== null){
            limitOrdersList= new ArrayList<>();
            limitOrders.put(stockId, limitOrdersList);
        }
        limitOrdersList.add(limitOrder);
    }
}
