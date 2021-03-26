package com.wmr.javaAdvance.exercises;

import com.wmr.javaAdvance.exercises.factory.INumberFactory;
import com.wmr.javaAdvance.exercises.service.INumberService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

/**
 * 输入三个数字并返回判断最大值与最小值
 */
public class NumberTest {
    public static void main(String[] args) {
        INumberService service = INumberFactory.getNumberService();
        int result[] = service.stat(5);
        System.out.println("最大值：" + result[0] + "\t最小值:" + result[1]);
    }
}
