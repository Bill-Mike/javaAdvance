package com.wmr.threadtest.productorandconsumer;

/**
 * 多线程最原始的方式，线程等待唤醒全部由coder自行编码
 */
public class Message {
    private String title;
    private String content;
    private boolean flag = true; //表示生产或消费的标志，true允许生产不允许消费，false与之相反
    public synchronized void set(String title, String content){
        if(!this.flag){
            try {
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.title = title;
        this.content = content;
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.flag = false;
        System.out.println("生产完成等待消费！");
        super.notify();
    }
    public synchronized String get(){
        if(this.flag){
            try {
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
            return this.title + ":" + this.content;
        }catch (InterruptedException e){
            e.printStackTrace();
            return "运行出错！";
        }finally {
            this.flag = true;
            super.notify();
            System.out.println("消费者消费完成等待生产");
        }
    }
}
