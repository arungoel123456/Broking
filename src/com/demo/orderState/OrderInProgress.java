package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;

public class OrderInProgress extends OrderState {
    public void notifyUsers(User user, ErrorCode errorCode) {
        // notify successful transaction
    }
}
