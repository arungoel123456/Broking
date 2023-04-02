package com.demo.services;

import com.demo.dto.*;

import java.util.*;

public class UserServiceImpl {
    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
    }

    public User createUser(String name){
        User user= new User(name);
        // you can have an authentication mechanism here also by sending otp.
        users.add(user);
        return user;
    }

    public Portfolio getPortfolio(User user){
        return user.getPortfolio();
    }

    public void addMoney(User user, int amount){
        user.setFund( user.getFund() + amount );
    }

    public void withdrawMoney(User user, int amount){
        if(user.getFund() < amount){
            System.out.println("You are withdrawing more than you have.");
            return;
        }
        user.setFund( user.getFund() - amount);
    }

}
