package com.wmr.javaAdvance.exercises.service.impl;

import com.wmr.javaAdvance.exercises.service.INumberService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

public class NumberService implements INumberService {

    @Override
    public int[] stat(int count) {
        int[] result = new int[2];
        int[] data = new int[count];
        for(int x = 0; x < count; x++){
            data[x] = InputUtil.getInt("请输入第" +(x+1)+"个数据！");
        }
        result[0] = data[0];
        result[1] = data[1];
        for(int x = 0; x <data.length; x ++){
            if (result[0] < data[x]) {
                result[0] = data[x];
            }
            if (result[1] > data[x]){
                result[1] = data[x];
            }
        }
        return result;
    }
}
