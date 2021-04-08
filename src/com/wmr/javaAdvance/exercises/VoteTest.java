package com.wmr.javaAdvance.exercises;

import com.wmr.javaAdvance.exercises.menu.VoteMenu;

/**
 * 投票选举：
 * 民主投票选班长，候选人有思维：1张三，2李四，3王五，4赵六
 * 程序操作人员将每张选票的代号1，2，3，4，循环输入电脑，输入0结束
 * 程序结束时，显示每位候选人的票数信息
 */
public class VoteTest {
    public static void main(String[] args) {
        new VoteMenu();
    }
}
