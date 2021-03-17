package com.wmr.threadtest.productorandconsumer;

import java.util.TreeMap;

public class ProducerImpl implements Runnable{
    private Message msg;
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(i % 2 == 0){
                this.msg.set("msg1", "msg 1 test message");
            }else{
                this.msg.set("msg2", "msg 2 test message");
            }
        }

    }
    public  ProducerImpl(Message msg){
        this.msg = msg;
    }
}
