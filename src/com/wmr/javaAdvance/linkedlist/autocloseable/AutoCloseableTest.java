package com.wmr.javaAdvance.linkedlist.autocloseable;

/**
 * AutoCloseable 必须和try catch中使用
 */
public class AutoCloseableTest {
    public static void main(String[] args) {
        try (IMessage msg = new NetMessage("test message content")){
            msg.send();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

interface IMessage extends AutoCloseable{
    void open();
    void send();
}

class NetMessage implements IMessage{
    private String msg;
    public NetMessage(String msg){
        this.msg = msg;
    }
    @Override
    public void open() {
        System.out.println("网络资源已打开");
    }

    @Override
    public void send() {
        this.open();
        System.out.println("message 发送："+ this.msg);
    }

    @Override
    public void close() throws Exception {
        System.out.println("网路资源已关闭");
    }
}
