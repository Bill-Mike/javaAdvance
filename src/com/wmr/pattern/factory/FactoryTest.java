package com.wmr.pattern.factory;

public class FactoryTest {
    public static void main(String[] args) {
        IFood iFood = Factory.getInstanceName(args[0]);
        if (iFood != null){
            iFood.eat();
        }

    }
}
