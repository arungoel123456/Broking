package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;

public class OrderFailed extends OrderState {
    @Override
    public void notifyUsers(User user, ErrorCode errorCode) {
        if(errorCode == ErrorCode.INSUFFICIENT_BALANCE){
            // notify users of insufficient balance;
        }
        else if(errorCode == ErrorCode.NO_STOCK_POSITIONS){
            // notify users of insufficient stock options
        }
    }
}
