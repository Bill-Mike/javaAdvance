package com.wmr.threadtest.deamonthread;

public class DaemonThreadTest2 {
    public static void main(String[] args) {
        try {
            MyThread2 thread2 = new MyThread2();
            thread2.setDaemon(true);
            thread2.setName("daemon thread2");
            thread2.start();
            thread2.sleep(5000);
            System.out.println(Thread.currentThread().getName()+": 我离开thread2d对象也不再打印了，thread线程停止");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class MyThread2 extends Thread{
    private int i = 0;
    @Override
    public void run() {
        while (true){
            i ++;
            System.out.println(Thread.currentThread().getName()+": i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
