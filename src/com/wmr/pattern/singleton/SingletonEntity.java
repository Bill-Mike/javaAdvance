package com.wmr.pattern.singleton;

/**
 * 懒汉式单例模式
 */
public class SingletonEntity {
    private String name;
    private volatile static SingletonEntity singletonEntity;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /* 一般情况，线程不安全
   public static SingletonEntity getInstance(){
        if(singletonEntity == null){
           singletonEntity = new SingletonEntity();
        }
        return singletonEntity;
    }
    */

    /*线程安全，但是同步单来性能损耗
    public static SingletonEntity getInstance(){
        synchronized(SingletonEntity.class) {
            if(singletonEntity == null){
                singletonEntity = new SingletonEntity();
            }
            return singletonEntity;
        }
    }
    */

    /*最完美的单例模式通过 volatile 关键字定义Singleton对象，在synchronized代码块中两次判断实例对象是否为空，尽量减小synchronized同步代码块对程序的有影响*/
    public static SingletonEntity getInstance(){

        if(singletonEntity == null){
            synchronized (SingletonHangerEntity.class){
                if (singletonEntity == null){
                    singletonEntity = new SingletonEntity();
                }
            }
        }

        return singletonEntity;
    }

 /*   *//* 使用静态内部类的方法最好，既避免了线程安全问题，又避免了同步问题*//*
    private static class LazyHolder{
        private static final SingletonEntity singletonEntity = new SingletonEntity();
    }

    public static final SingletonEntity getInstance(){
        return LazyHolder.singletonEntity;
    }
    private SingletonEntity(){

    }*/
}
