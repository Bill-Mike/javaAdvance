package com.wmr.pattern.factory;

public class Milk implements IFood{
    @Override
    public void eat() {
        System.out.println("喝牛奶");
    }
}
