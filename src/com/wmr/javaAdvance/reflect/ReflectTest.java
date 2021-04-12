package com.wmr.javaAdvance.reflect;

import com.wmr.javaAdvance.exercises.entity.Candidate;
import com.wmr.javaAdvance.exercises.entity.Student;

public class ReflectTest {
    public static void main(String[] args) {
        Candidate candidate = new Candidate(1,"zhangsan", 0);
        Class<? extends Candidate> c = candidate.getClass(); //第一种方式，通过对象的getClass方法获取Class对象 需要实例化一个指定类对象，可能造成浪费
        System.out.println(c.toString());   //获取类的完整名称

        Class<? extends Candidate> c1 = Candidate.class; //第二种方式类名称.class   需要导入相应的开发包
        System.out.println(c1.toString());
        try {
            Class<?> stuc = Class.forName("com.wmr.javaAdvance.exercises.entity.Candidate");
            System.out.println(stuc.toString());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
