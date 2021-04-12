package com.wmr.javaAdvance.reflect;

import com.wmr.javaAdvance.exercises.entity.Candidate;

/**
 * 反射实例化对象
 */
public class ReflectInstantiation {
    public static void main(String[] args) {

        try {
            Class<?> stuc = Class.forName("com.wmr.javaAdvance.exercises.entity.Candidate");
            Candidate su = (Candidate) stuc.newInstance();
            su.setPoll(10);
            su.setName("aaa");
            su.setNum(1);
            System.out.println(su.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
    }
}
