package com.wmr.threadtest.threadlocal;

import java.lang.instrument.Instrumentation;

/*
消息发送通道
 */
class Channel{
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<>();

    public static void setMsg(Message msg) {
        Channel.THREAD_LOCAL.set(msg);
    }
    public static void send(){
        System.out.println(Thread.currentThread().getName()+" 消息发送："+THREAD_LOCAL.get().getContent());
        THREAD_LOCAL.remove();
    }
    private Channel(){}
}
/*
要发送的消息体
 */
class Message{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i:new int[]{1,2,3,4,5,6}
             ) {
            new Thread(() -> {
                Message msg = new Message();
                msg.setContent("test Message t1" + ":" + i);
                Channel.setMsg(msg);
                Channel.send();
            },"t1" + ":" + i).start();
            new Thread(() -> {
                Message msg = new Message();
                msg.setContent("test Message t2" + ":" + i);
                Channel.setMsg(msg);
                Channel.send();
            },"t2" + ":" + i).start();
            new Thread(() -> {
                Message msg = new Message();
                msg.setContent("test Message t3" +  ":" + i);
                Channel.setMsg(msg);
                Channel.send();
            },"t3" + ":" + i).start();
        }

    }
}
