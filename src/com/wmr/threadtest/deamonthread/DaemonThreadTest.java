package com.wmr.threadtest.deamonthread;

public class DaemonThreadTest {
    private static boolean flag = true;

    public static void main(String[] args) {
        Thread userThread = new Thread(()->{
            int i = 0;
            while (i < 3){
                System.out.println(Thread.currentThread().getName() + "running！！！");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
            }
        },"业务线程");

        Thread daemonThread = new Thread(()->{
            while (flag){
                System.out.println(Thread.currentThread().getName()+ "running!!!!!");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"守护线程");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}
