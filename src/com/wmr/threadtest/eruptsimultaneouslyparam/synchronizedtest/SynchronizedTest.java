package com.wmr.threadtest.eruptsimultaneouslyparam.synchronizedtest;

/**
 * synchronized锁对象为非this情况时的测试，其多个线程可以同时进入同步代码块，修改类的属性，线程不安全，会出现b,aa的情况
 */

public class SynchronizedTest {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");
        threadB.start();
    }
}

class Service{
    private String usernameParam;
    private String passwordParam;

    public void setUsernamePassword(String usernameParam, String passwordParam){
        try {
            String anyString = new String();
            System.out.println(this.usernameParam + ":" + this.passwordParam);
            synchronized (anyString){
                System.out.println(Thread.currentThread().getName() + "-----" + System.currentTimeMillis()+ "进入同步代码块");
                this.usernameParam = usernameParam;
                System.out.println(this.usernameParam + ":" + this.passwordParam);
                Thread.sleep(3000);
                System.out.println(this.usernameParam + ":" + this.passwordParam);
                this.passwordParam = passwordParam;
                System.out.println(this.usernameParam + ":" + this.passwordParam);
                System.out.println(Thread.currentThread().getName() + "-----" + System.currentTimeMillis()+ "离开同步代码块");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service ser){
        super();
        this.service = ser;
    }

    @Override
    public void run() {
        super.run();
        service.setUsernamePassword("a", "aa");
    }
}
class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service ser){
        super();
        this.service = ser;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");
    }
}
