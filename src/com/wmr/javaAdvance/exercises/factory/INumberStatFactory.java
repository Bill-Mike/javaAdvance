package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.service.INumberService;
import com.wmr.javaAdvance.exercises.service.impl.NumberServiceOfStatImpl;

//定义工厂
public class INumberStatFactory {
    private INumberStatFactory(){}

    public static NumberServiceOfStatImpl getInstance(){
        return new NumberServiceOfStatImpl();
    }
}
