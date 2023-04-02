package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.interfaces.*;
import com.demo.services.*;

public class OrderInProgress extends OrderState {

    public OrderInProgress() {
        super(new EmailNotificationImpl());
    }

    public void notifyUsers(User user, ErrorCode errorCode) {
        notificationService.sendNotification("errorCode " , user);
    }
}
