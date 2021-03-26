package com.wmr.javaAdvance.serializable;

import java.io.*;

public class SerializableTest {
    private static final File SAVE_FILE = new File("D:\\test\\test.txt");
    /**
     * 序列化与反序列化操作
     * @param args
     */
    public static void main(String[] args) throws Exception{
        saveObject(new Person("榴莲君", 80));
        Person liu = (Person) getObject();
        System.out.println(liu.getAge() + liu.getName());
    }
    //序列化操作
    public static void saveObject(Object obj) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();
    }
    //反序列化操作
    public static Object getObject() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}

//实现Serializable表示类可以序列化
class Person implements Serializable {
    private static final long serializable = 1L;
    private transient String name;  //transient 表示name属性不序列化处理
    private int age;
    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
