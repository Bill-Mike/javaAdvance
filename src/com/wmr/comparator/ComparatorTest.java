package com.wmr.comparator;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        int[] data = new int[]{3,6,4,77,44,22,88,99,100};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }

}

class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}