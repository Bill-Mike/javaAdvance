package com.wmr.threadtest.addandsub;

/**
 * 多线程加减问题
 */
public class AddAndSubTest {
    public static void main(String[] args) {
        Resource res = new Resource();
        AddResource ad = new AddResource(res);
        SubResource sub = new SubResource(res);
        new Thread(ad,"add A").start();
        new Thread(ad, "add B").start();
        new Thread(sub, "sub C").start();
        new Thread(sub, "sub D").start();
    }
}

class Resource{
    private int num;
    private boolean flag = true; //true的时候可以加，false的时候可以减
    public synchronized void add() throws InterruptedException{
        while(!this.flag){
            this.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println(Thread.currentThread().getName() + "running add" + "num:" + num);
        this.flag = false;
        this.notifyAll();
    }

    public synchronized void sub() throws InterruptedException{
        while (this.flag){
            this.wait();
        }
        this.num--;
        System.out.println(Thread.currentThread().getName() + "running sub" + "num:" + num);
        this.flag = true;
        this.notifyAll();
    }
}

class AddResource implements Runnable{
    private Resource res;

    public AddResource(Resource res){
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                this.res.add();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class SubResource implements Runnable{
    private Resource res;
    public SubResource(Resource res){
        this.res = res;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                this.res.sub();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


