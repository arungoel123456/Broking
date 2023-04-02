package com.demo.services;

import com.demo.dto.*;
import com.demo.interfaces.*;

public class EmailNotificationImpl implements NotificationService {
    @Override
    public void sendNotification(String description, User user) {
        Notification notification = new Notification(description);
        System.out.println("Hey, in email notification with " + description + " : "+ user.getName());
    }
}
