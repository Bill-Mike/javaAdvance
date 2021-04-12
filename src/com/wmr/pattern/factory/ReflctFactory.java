package com.wmr.pattern.factory;

/**
 * 利用反射传入类名称动动态返回实例，解除类间的耦合，去除if else等繁琐的判断
 */
public class ReflctFactory {
    private ReflctFactory(){};

    public static IMessage getInstance(String className){
        IMessage iMessage = null;
        try {
            iMessage = (IMessage) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMessage;
    }

    public static void main(String[] args) {
        IMessage msg = ReflctFactory.getInstance("com.wmr.pattern.factory.NetMessage");
        msg.send();
    }
}

interface IMessage{
    void send();
}

class NetMessage implements IMessage{
    @Override
    public void send() {
        System.out.println(
            "hello world! this is netmessage"
        );
    }
}