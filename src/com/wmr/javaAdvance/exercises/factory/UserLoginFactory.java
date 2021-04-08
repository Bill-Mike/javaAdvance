package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.proxy.UserLoginProxy;
import com.wmr.javaAdvance.exercises.service.IUserService;
import com.wmr.javaAdvance.exercises.service.impl.UserServiceImpl;

public class UserLoginFactory {
    private UserLoginFactory(){}

    public static IUserService getInstance(){
        return new UserLoginProxy(new UserServiceImpl());
    }
}
