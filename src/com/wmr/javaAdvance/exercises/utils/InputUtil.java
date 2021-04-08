package com.wmr.javaAdvance.exercises.utils;

import java.util.Scanner;

public class InputUtil {
    private InputUtil(){}

    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;
        while (flag){
            System.out.println(prompt); //的输出提示信息
            Scanner input = new Scanner(System.in);
            if(input.hasNext("\\d+")){
                num = Integer.valueOf(input.next("\\d+"));
                flag = false;
            }else {
                System.out.println("请输入数字！");
            }
        }
        return num;
    }

    public static String getString(String pormpt){
        String str = null;
        boolean flag = true;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(pormpt);
            if (input.hasNext()){
                str = input.next().trim();
                if(!"".equals(str)){
                    flag = false;
                }else{
                    System.out.println("输入的内容不能为空！");
                }
            }else {

            }
        }
        return str;
    }
}
