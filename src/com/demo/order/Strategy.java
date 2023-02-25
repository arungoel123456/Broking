package com.demo.order;

import com.demo.dto.*;

public interface Strategy {
    boolean validate(Order order);
}
