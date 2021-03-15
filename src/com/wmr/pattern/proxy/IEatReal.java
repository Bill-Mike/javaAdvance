package com.wmr.pattern.proxy;

public class IEatReal implements IEat{
    @Override
    public void get() {
        System.out.println("【真实主题】得到一份食物，开始吃！");
    }
}
