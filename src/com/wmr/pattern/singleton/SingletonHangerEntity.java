package com.wmr.pattern.singleton;

public class SingletonHangerEntity {
    private String name;
    private static final SingletonHangerEntity singletonHangerEntity = new SingletonHangerEntity();
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private SingletonHangerEntity(){

    }

    public static SingletonHangerEntity getInstance(){
        return singletonHangerEntity;
    }
}
