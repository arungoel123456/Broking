package com.demo.order;

import com.demo.dto.*;

public class BuyValidationStrategy implements Strategy{
    @Override
    public boolean validate(Order order) {
        return false;
    }
}
