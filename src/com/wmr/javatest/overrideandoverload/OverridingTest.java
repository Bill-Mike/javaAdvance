package com.wmr.javatest.overrideandoverload;

public class OverridingTest {
    public static void main(String[] args) {
        Dog dog = new Hound();
        dog.bark();
    }
}

class Dog{
    public void bark(){
        System.out.println("woof");
    }
}

class Hound extends Dog{
    public void snoff(){
        System.out.println("sniff");
    }

    public void bark(){
        System.out.println("bowl");
    }
}

