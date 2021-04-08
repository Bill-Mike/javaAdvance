package com.wmr.javaAdvance.exercises;

import com.wmr.javaAdvance.exercises.factory.INumberStatFactory;

import java.util.Arrays;

/**
 * 从控制台输入数字统计输入数字中的奇数偶数个数
 */
public class NumberStatTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(INumberStatFactory.getInstance().stat()));
    }
}

