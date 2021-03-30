package com.wmr.javaAdvance.exercises.menu;

import com.wmr.javaAdvance.exercises.factory.StringReverseFactory;
import com.wmr.javaAdvance.exercises.service.IStringService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

import java.util.Arrays;

public class StringMenu {

    private IStringService stringService;

    public StringMenu(){
       this.stringService = StringReverseFactory.getInstance();
       this.show();
       this.choose();

    }

    public void show(){
        System.out.println("【1】追加字符产数据");
        System.out.println("【2】逆序显示所有的字符串数据");
        System.out.println("【3】推出程序");
        System.out.println("\n\n\n");
    }

    public void choose(){
        String choose = InputUtil.getString("请进行选择");

        switch (choose){
            case "1":{
                String str = InputUtil.getString("请输入字符串数据");
                this.stringService.append(str);
                choose();
            } case "2":{
                String[] result = this.stringService.reverse();
                System.out.println(Arrays.toString(result));
                choose();
            } case "3":{
                System.out.println("再见！");
                System.exit(0);
            } default:{
                System.out.println("你的选择不在选项中");
                choose();
            }
        }
    }
}
