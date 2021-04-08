package com.wmr.javaAdvance.exercises.service.impl;

import com.wmr.javaAdvance.exercises.service.IUserService;

import java.util.Date;

public class UserServiceImpl implements IUserService {

    private int count = 0;
    @Override
    public boolean isExit() {
        return this.count >= 3;
    }

    @Override
    public boolean login(String name, String password) {
        /*if (name.equals("admin") && password.equals("111111")){
            System.out.println("用户：" + name + "登陆成功！");
            System.out.println("登陆时间" + new Date());
        }else {
            this.count ++;
            if (isExit()){
                System.out.println("程序将在1秒后退出！");
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    System.exit(1);
                }
            }
        }
        return false;*/
        this.count ++;
        return "admin".equals(name) && "111111".equals(password);
    }
}
