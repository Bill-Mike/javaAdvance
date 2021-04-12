package com.wmr.javaAdvance.reflect;

public class ReflectAndFactory {
    public static void main(String[] args) {
        try {
            IMessage msg = Factory.getInstance(IMessage.class,"com.wmr.javaAdvance.reflect.NetMessage");
            msg.send();
            IService service = Factory.getInstance(IService.class,"com.wmr.javaAdvance.reflect.HouseService");
            service.service();
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

interface IService{
    public void service();
}

class HouseService implements IService{
    @Override
    public void service() {
        System.out.println("提供房子的打扫服务！");
    }
}

class Factory{
    private Factory(){}

    public static <T> T getInstance(Class<T> clazz, String className) throws Exception{
        return (T) Class.forName(className).newInstance();
    }
}