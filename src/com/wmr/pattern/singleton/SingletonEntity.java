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

    /* 使用静态内部类的方法最好，既避免了线程安全问题，又避免了同步问题*/
    private static class LazyHolder{
        private static final SingletonEntity singletonEntity = new SingletonEntity();
    }

    public static final SingletonEntity getInstance(){
        return LazyHolder.singletonEntity;
    }
    private SingletonEntity(){

    }
}
