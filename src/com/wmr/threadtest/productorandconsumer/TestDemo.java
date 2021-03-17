package com.wmr.threadtest.productorandconsumer;

public class TestDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new ProducerImpl(msg)).start(); //启动生产者线程
        new Thread(new ConsumerImpl(msg)).start(); //启动消费之线程
    }
}
