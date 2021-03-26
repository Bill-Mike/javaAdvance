package com.wmr.javaAdvance.exercises.service;

//第一一个标准
public interface INumberService {
    /**
     * 输入数据，并返回输入数据的最大值与最小值
     * @param count 输入数据的个数
     * @return 返回数组第一个表示最大值，第二个表示最小值
     */
    public int[] stat(int count);
}
