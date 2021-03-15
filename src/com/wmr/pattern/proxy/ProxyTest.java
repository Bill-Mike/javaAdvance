package com.wmr.pattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        IEat eat = new EatProxy(new IEatReal());
        eat.get();
    }
}
