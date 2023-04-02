package com.demo.order;

import com.demo.dto.*;

public class BuyValidationStrategy implements Strategy{

    public BuyValidationStrategy() {
    }

    @Override
    public boolean validate(Order order) {
        User user= order.getUser();
        return order.getUser().checkFund(order.getPrice() * order.getQty() );
    }
}
