package com.wmr.javaAdvance.exercises.service.impl;

import com.wmr.javaAdvance.exercises.service.IStringService;

public class StringServiceImpl implements IStringService {
    private StringBuffer data = new StringBuffer();


    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String[] result = this.data.toString().split("\\|");
        int center = result.length / 2;
        int head = 0;
        int tail = result.length - 1;
        for(int x = 0; x < center; x++){
            String temp = result[head + x];
            result[head + x] = result[tail -x];
            result[tail - x ] = temp;
        }
        return result;
    }
}
