package com.wmr.javaAdvance.timertask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 原始使用方法，在现实应用中使用非常麻烦，建议使用其他框架进行定时调度任务
 */
public class TimerTaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(),1000, 1000); //delay 延时执行，period间隔时间
    }
}

class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 执行定时任务， 当前时间" + System.currentTimeMillis());
    }
}