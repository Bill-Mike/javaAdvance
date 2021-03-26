package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.service.INumberService;
import com.wmr.javaAdvance.exercises.service.impl.NumberService;

public class INumberFactory {
    private INumberFactory(){}

    public static INumberService getNumberService(){
        return new NumberService();
    }
}
