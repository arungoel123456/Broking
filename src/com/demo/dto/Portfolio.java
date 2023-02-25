package com.demo.dto;

import java.util.*;

public class Portfolio {
    private String userId;
    private Map<Stock, PortfolioStock> portfolio;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Stock, PortfolioStock> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Map<Stock, PortfolioStock> portfolio) {
        this.portfolio = portfolio;
    }
}
