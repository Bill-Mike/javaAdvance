package com.wmr.threadtest.productorandconsumer;

public class ConsumerImpl implements Runnable{
    private Message msg;

    public ConsumerImpl(Message msg){
        this.msg = msg;

    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.get());
        }
    }
}
