package com.demo.order;

import com.demo.dto.*;

public class SellValidationStrategy implements Strategy  {
    @Override
    public boolean validate(Order order) {
        return false;
    }
}
