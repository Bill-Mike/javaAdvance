package com.wmr.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {
    private int a;
    private int b;
    public CallableTest(int a, int b){
        this.a= a;
        this.b = b;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("running !!!!!!!!!!!");
        return this.a + this.b;
    }
}

class RunTest{
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest(10, 20);
        try {
            FutureTask task = new FutureTask(callableTest);
            Thread thread = new Thread(task);
            thread.start();
            System.out.println(task.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
