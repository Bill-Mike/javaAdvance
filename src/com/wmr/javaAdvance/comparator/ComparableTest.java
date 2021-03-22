package com.wmr.javaAdvance.comparator;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        int[] data = new int[]{3,6,4,77,44,22,88,99,100};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        Person[] pers = new Person[3];
        Person p1 = new Person("aa", 1);
        Person p2 = new Person("bb", 5);
        Person p3 = new Person("cc", 4);
        pers[0] = p1;
        pers[1] = p2;
        pers[2] = p3;
        Arrays.sort(pers);
        System.out.println(Arrays.toString(pers));
    }

}

class Person implements Comparable<Person>{
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
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}