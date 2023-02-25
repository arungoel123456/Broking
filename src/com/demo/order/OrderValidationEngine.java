package com.demo.order;

import com.demo.dto.*;

public class OrderValidationEngine {
    private Strategy orderValidationStrategy;
    public OrderValidationEngine(Strategy orderValidationStrategy){
        this.orderValidationStrategy= orderValidationStrategy;
    }

    public Strategy getOrderValidationStrategy() {
        return orderValidationStrategy;
    }

    public void setOrderValidationStrategy(Strategy orderValidationStrategy) {
        this.orderValidationStrategy = orderValidationStrategy;
    }

    public boolean validate(Order order){
        if(isFraud(order.getUser())){
            return false;
        }
        return orderValidationStrategy.validate(order);
    }

    private boolean isFraud(User user){
        return false;
    }
}
