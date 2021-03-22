package com.wmr.javaAdvance.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * comparator 时挽救式的方法，在项目已经完成， 原代码不能修改的情况下使用的
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person1[] pers = new Person1[3];
        Person1 p1 = new Person1("aa", 55);
        Person1 p2 = new Person1("bb", 33);
        Person1 p3 = new Person1("cc", 66);
        pers[0] = p1;
        pers[1] = p2;
        pers[2] = p3;
        Arrays.sort(pers, new Person1Comparator());
        System.out.println(Arrays.toString(pers));
    }
}

class Person1Comparator implements Comparator<Person1> {
    @Override
    public int compare(Person1 p1, Person1 p2) {
        return p1.getAge()- p2.getAge();
    }
}

class Person1{
    private String name;
    private int age;

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
    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
