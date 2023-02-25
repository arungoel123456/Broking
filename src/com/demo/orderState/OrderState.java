package com.demo.orderState;


import com.demo.dto.*;
import com.demo.enums.*;

public abstract class OrderState {
    public abstract void notifyUsers(User user, ErrorCode errorCode);

}
