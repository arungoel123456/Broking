package com.demo.services;

import com.demo.dto.*;
import com.demo.interfaces.*;

public class SmsNotificationImpl implements NotificationService {
    @Override
    public void sendNotification(String description, User user) {
        Notification sms= new Notification(description);
        System.out.println("Hey, in sms notification with " + description + " : "+ user.getName());
    }
}
