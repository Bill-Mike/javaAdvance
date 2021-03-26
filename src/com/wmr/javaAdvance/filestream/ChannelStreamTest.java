package com.wmr.javaAdvance.filestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ChannelStreamTest {
    public static void main(String[] args) throws IOException {
        SendThread sendThread = new SendThread();
        ReceiveThread receiveThread = new ReceiveThread();
        sendThread.getOutputStream().connect(receiveThread.getInputStream());
        new Thread(sendThread, "sender Thread").start();
        new Thread(receiveThread, "getter Thread").start();
    }
}

class SendThread implements Runnable{
    private PipedOutputStream outputStream;

    @Override
    public void run() {
        try {
            this.outputStream.write(("第"+"次发送数据"+Thread.currentThread().getName()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SendThread(){
        this.outputStream = new PipedOutputStream();    //实例化管道输出流
    }

    public PipedOutputStream getOutputStream(){
        return outputStream;
    }
}

class ReceiveThread implements Runnable{
    private PipedInputStream inputStream;
    @Override
    public void run() {
        byte[] data = new byte[1024];
        for(int i = 0; i <10; i++){
            try {
                int len = this.inputStream.read(data);
                System.out.println(Thread.currentThread().getName()+"{接收消息}"+ new String(data));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReceiveThread(){
        this.inputStream = new PipedInputStream();
    }

    public PipedInputStream getInputStream(){
        return inputStream;
    }
}