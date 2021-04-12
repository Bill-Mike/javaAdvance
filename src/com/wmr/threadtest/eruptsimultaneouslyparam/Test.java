package com.wmr.threadtest.eruptsimultaneouslyparam;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            ThreadA threadA = new ThreadA(service);
            threadA.setName("a");
            threadA.start();
            Thread.sleep(500);
            ThreadB threadB = new ThreadB(service);
            threadB.setName("b");
            threadB.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

/*
class Main{
    public int i = 10;
    synchronized public void operateMainMethod(){
        try {
            i --;
            System.out.println("Main print i =" + i);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Sub extends Main{
    @Override
    synchronized public void operateMainMethod(){
        try {
            while ( i > 0){
                i --;
                System.out.println("Sub print i =" + i);
                Thread.sleep(100);
                super.operateMainMethod(); //调用父类的方法共同操作变量i
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Run implements Runnable{
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateMainMethod();
    }
}*/

class Service{
    synchronized public void testMethod(){
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("thread name:" + Thread.currentThread().getName() + " run begin time" + System.currentTimeMillis());
            int i = 1;
            while (i == 1){
                if(("" + Math.random()).substring(0, 8).equals("0.123456")){
                    System.out.println("thread name" + Thread.currentThread().getName() + " run exceptionTime=" + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println("Thread B run time=" + System.currentTimeMillis());
        }
    }
}

class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
