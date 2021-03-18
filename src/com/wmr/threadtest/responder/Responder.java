package com.wmr.threadtest.responder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Responder {
    public static void main(String[] args) {
        int i= 0;
        while (i < 1000){
            MyThread myThread = new MyThread();
            FutureTask futureTask = new FutureTask(myThread);
            new Thread(futureTask, "竞赛者A").start();
            new Thread(futureTask, "竞赛者B").start();
            new Thread(futureTask, "竞赛者C").start();
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            i ++;
        }

    }
}

class MyThread implements Callable<String>{
    private boolean flag = false;
    @Override
    public String call() throws Exception {
        synchronized (this){
            if(this.flag == false){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功！";
            }
        }
        return null;
    }
}