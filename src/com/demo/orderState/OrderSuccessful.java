package com.demo.orderState;

import com.demo.dto.*;
import com.demo.enums.*;

public class OrderSuccessful extends OrderState {
    @Override
    public void notifyUsers(User user, ErrorCode errorCode) {
        // notify successful transaction
    }
}
