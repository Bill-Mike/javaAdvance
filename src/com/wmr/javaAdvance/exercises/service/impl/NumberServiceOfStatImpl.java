package com.wmr.javaAdvance.exercises.service.impl;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

public class NumberServiceOfStatImpl implements INumberStatService {
    @Override
    public int[] stat() {
        int stat[] = new int[] {0,0}; //第一个数字为奇数统计，第二个数字为偶数统计
        String msg = InputUtil.getString("请输入数字信息：");
        String result[] = msg.split(""); //按照每个字符拆分
        for (int x = 0; x < result.length; x ++){
            if(Integer.valueOf(result[x]) % 2 == 0){
                stat[1] ++;
            }else {
                stat[0] ++;
            }
        }
        return stat;
    }
}
