package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.service.IStringService;
import com.wmr.javaAdvance.exercises.service.impl.StringServiceImpl;

public class StringReverseFactory {
    private StringReverseFactory(){}

    public static IStringService getInstance(){
        return new StringServiceImpl();
    }
}
