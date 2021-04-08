package com.wmr.javaAdvance.exercises.proxy;

import com.wmr.javaAdvance.exercises.service.IUserService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

import java.util.Date;

/**
 * 真是业务只是先核心功能，其他的辅助业务交给代理
 */
public class UserLoginProxy implements IUserService {
    private IUserService userService;

    public UserLoginProxy(IUserService iUserService){
        this.userService = iUserService;
    }

    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while (!this.isExit()){
            String inputData = InputUtil.getString("请输入用户登陆信息");
            if (inputData.contains("/")){
                String[] data = inputData.split("/");
                if(this.userService.login(data[0], data[1])){
                    System.out.println("用户：" + data[0] + "于" + new Date() + "登陆成功");
                    return true;
                }else {
                    System.out.println("用户名或密码不正确！");
                }
            }else {
                String pwd = InputUtil.getString("密码不能为空，请输入密码");
                if(this.userService.login(inputData, pwd)){
                    System.out.println("用户：" + inputData + "于" + new Date() + "登陆成功");
                    return true;
                }else {
                    System.out.println("用户名或密码不正确！");
                }
            }
        }
        System.out.println("用户名密码错误次数达到三次");
        return false;
    }
}
