package com.demo.interfaces;

import com.demo.dto.*;

public interface NotificationService {
    public void sendNotification(String description, User user);
}
