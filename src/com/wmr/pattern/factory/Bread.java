package com.wmr.pattern.factory;

public class Bread implements IFood{
    @Override
    public void eat() {
        System.out.println("吃面包");
    }
}
