package com.wmr.javaAdvance.cloneable;

public class CloneableTest {
    public static void main(String[] args) {
        Member m1 = new Member("a", 10);
        Member m2 = null;
        try {
            m2 = (Member)m1.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m1 == m2);

    }
}
/*
实现Cloneable（没有方法是一个能力的表示接口）接口，重写clone（）方法
 */
class Member implements Cloneable{
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

    public Member(Member m){
        this.name = m.name;
        this.age = m.age;
    }
    public Member(){}
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.hashCode() + "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
