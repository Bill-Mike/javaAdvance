package com.wmr.pattern.proxy;

public class EatProxy implements IEat{
    private IEat eat;
    public EatProxy(IEat eat){
        this.eat = eat;
    }

    public void prepare(){
        System.out.println("【代理主题】1.购买食材");
        System.out.println("【代理主题】2.处理食材");
    }
    public void clear(){
        System.out.println("【代理主题】3.清洁餐具");
    }

    @Override
    public void get() {
        this.prepare();
        this.eat.get();
        this.clear();
    }
}
