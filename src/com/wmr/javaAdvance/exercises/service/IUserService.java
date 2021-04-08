package com.wmr.javaAdvance.exercises.service;

public interface IUserService {
    public boolean isExit();    //是否退出
    public boolean login(String name, String password); //用户登陆
}
