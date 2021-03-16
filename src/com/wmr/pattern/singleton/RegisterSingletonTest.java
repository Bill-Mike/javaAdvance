package com.wmr.pattern.singleton;

import com.wmr.javaAdvance.FuncInterfaceTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 登记单例模式，实际上是维护了一组单例类的实例，将这些实例放在一个map中，对于登记过的直接从map中返回，没有登记过的先登记在返回。
 */
public class RegisterSingletonTest {
    private static Map<String, RegisterSingletonTest> map = new HashMap<>();
    static {
        RegisterSingletonTest registerSingletonTest = new RegisterSingletonTest();
        map.put(registerSingletonTest.getClass().getName(), registerSingletonTest);
    }
    protected RegisterSingletonTest(){

    }

    public static RegisterSingletonTest getInstance(String name){
        if(name == null){
            name = RegisterSingletonTest.class.getName();
            System.out.println("name == null" + "---->name=" + name);
        }
        if(map.get(name) == null){
            try {
                map.put(name, (RegisterSingletonTest) Class.forName(name).newInstance());
            } catch (InstantiationException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

    public String about(){
        return "hello, I'm RegisterStingleton Test";
    }

    public static void main(String[] args) {
        RegisterSingletonTest registerSingletonTest = RegisterSingletonTest.getInstance(null);
        System.out.println(registerSingletonTest.about());
    }
}
