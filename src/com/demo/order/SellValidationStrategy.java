package com.demo.order;

import com.demo.dto.*;

public class SellValidationStrategy implements Strategy  {

    public SellValidationStrategy() {
    }

    @Override
    public boolean validate(Order order) {
        return order.getUser().checkStockInPortfolio( order.getStockId(), order.getQty() );
    }
}
