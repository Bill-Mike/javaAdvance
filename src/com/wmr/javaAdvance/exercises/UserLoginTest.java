package com.wmr.javaAdvance.exercises;

import com.wmr.javaAdvance.exercises.factory.UserLoginFactory;

/**
 * 从命令行输入用户密码，如果没有输入而提示输入。判断用户名密码是否admin，111111成功则提示用户登陆成功，失败重新输入，三次输入错误程序停止
 */
public class UserLoginTest {
    public static void main(String[] args) {
        System.out.println(UserLoginFactory.getInstance().login(null, null));
    }
}
