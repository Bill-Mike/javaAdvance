package com.wmr.javaAdvance;

public class lambdaTest{
    public static void main(String[] args) {
        IMessage message = new IMessage() {
            @Override
            public void print() {
                System.out.println("hello world!");
            }
        };
        message.print();

        IMessage msg = () -> System.out.println("hello world!");
        msg.print();

        IMath result = (p1, p2) -> p1 + p2;
        System.out.println(result.add(10, 20));
        FuncInterfaceTest test = (p1, p2) -> {
            return p1 + p2;
        };
        System.out.println(test.add(10, 20));
    }
}
@FunctionalInterface
interface IMessage{
    public void print();
}

@FunctionalInterface
interface IMath{
    public int add(int a, int b);
}