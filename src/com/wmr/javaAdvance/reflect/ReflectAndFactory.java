package com.wmr.javaAdvance.reflect;

public class ReflectAndFactory {
    public static void main(String[] args) {
        try {
            IMessage msg = Factory.getInstance("com.wmr.javaAdvance.reflect.NetMessage");
            msg.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface IMessage{
    public void send();
}
class NetMessage implements IMessage{
    @Override
    public void send() {
        System.out.println("调用网络发送消息");
    }
}

class Factory{
    private Factory(){}

    public static IMessage getInstance(String className) throws Exception{
        return (IMessage) Class.forName(className).newInstance();
    }
}