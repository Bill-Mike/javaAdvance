package com.wmr.threadtest.stopthread;

public class StopThreadDemo{
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(() ->{
            long num = 0;
            while (flag){
                try {
                    Thread.sleep(50);
                    System.out.println("线程执行！");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }).start();
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag = false;
    }
}
