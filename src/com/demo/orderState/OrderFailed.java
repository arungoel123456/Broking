package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.interfaces.*;
import com.demo.services.*;

public class OrderFailed extends OrderState {

    public OrderFailed() {
        super(new SmsNotificationImpl());
    }

    @Override
    public void notifyUsers(User user, ErrorCode errorCode) {
        if(errorCode == ErrorCode.INSUFFICIENT_BALANCE){
            notificationService.sendNotification("Insufficient balance:  " , user);
        }
        else if(errorCode == ErrorCode.NO_STOCK_POSITIONS){
            notificationService.sendNotification("NO_STOCK_POSITIONS:  " , user);
        }
    }
}
