package com.demo.dto;

import java.util.*;

public abstract class Notification {
    private String notificationId;
    private Date creationDate;
    private String description;
    public abstract boolean sendNotification();
}
