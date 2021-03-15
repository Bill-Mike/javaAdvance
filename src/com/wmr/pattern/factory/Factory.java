package com.wmr.pattern.factory;

public class Factory {
    public static IFood getInstanceName(String className){
        if ("bread".equals(className)){
            return new Bread();
        }else if("milk".equals(className)){
            return new Milk();
        }else{
            return null;
        }
    }
}
