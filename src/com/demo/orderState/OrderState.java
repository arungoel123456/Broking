package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.interfaces.*;

public abstract class OrderState {
    protected NotificationService notificationService;

    public OrderState(NotificationService notificationService){
        this.notificationService= notificationService;
    }

    public abstract void notifyUsers(User user, ErrorCode errorCode);

}
