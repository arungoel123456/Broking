package com.demo.orderState;

import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.interfaces.*;
import com.demo.services.*;

public class OrderSuccessful extends OrderState {

    public OrderSuccessful() {
        super(new SmsNotificationImpl());
    }

    @Override
    public void notifyUsers(User user, ErrorCode errorCode) {
        notificationService.sendNotification("order successful ", user);
    }
}
