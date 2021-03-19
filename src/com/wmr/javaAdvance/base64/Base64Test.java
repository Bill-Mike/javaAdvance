package com.wmr.javaAdvance.base64;

import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        String msg = "hello world!";
        System.out.println(msg);
        String encode = new String(Base64.getEncoder().encode(msg.getBytes()));
        System.out.println(encode);
        String oldMsg = new String(Base64.getDecoder().decode(encode));
        System.out.println(oldMsg);
        String repeatEncode= StringUtil.encode(msg);
        System.out.println(repeatEncode);
        String repeatDecode = StringUtil.decode(repeatEncode);
        System.out.println(repeatDecode);

    }
}

class StringUtil{
    private static final String SALT = "12345677";
    private static final int REPEAT = 3;
    public static String encode(String msg){
        String temp = msg + "{" + SALT + "}";
        byte[] data = temp.getBytes();
        for(int i = 0; i < REPEAT; i++){
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }
    public static String decode(String encode){
        String temp = encode;
        byte[] data = encode.getBytes();
        for(int i = 0; i < REPEAT; i++){
            data = Base64.getDecoder().decode(data);
        }
        temp = new String(data);
        String[] datas = temp.split("\\{");
        return datas[0];
    }
}
