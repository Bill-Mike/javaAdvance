package com.wmr.pattern.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonEntity singletonEntity1 = SingletonEntity.getInstance();
        singletonEntity1.setName("aaaa");
        SingletonEntity singletonEntity2 = SingletonEntity.getInstance();
        System.out.println(singletonEntity2.getName());
        singletonEntity2.setName("aaaaaabbb");
        System.out.println(singletonEntity1.getName());

        SingletonHangerEntity singletonHangerEntity1 = SingletonHangerEntity.getInstance();
        singletonHangerEntity1.setName("abc");
        SingletonHangerEntity singletonHangerEntity2 = SingletonHangerEntity.getInstance();
        System.out.println(singletonHangerEntity1.getName());
        singletonHangerEntity2.setName("cba");
        System.out.println(singletonHangerEntity2.getName());
    }
}
