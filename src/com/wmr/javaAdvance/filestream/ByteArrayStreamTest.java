package com.wmr.javaAdvance.filestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 内存流测试类
 */
public class ByteArrayStreamTest {
    public static void main(String[] args) throws Exception{
        String str = "hello world!!!!!";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        int data = 0;
        while ((data = inputStream.read()) != -1){
            outputStream.write(Character.toUpperCase((char)data));
        }
        System.out.println(new String(((ByteArrayOutputStream)outputStream).toByteArray()));
        System.out.println(((ByteArrayOutputStream) outputStream).toString());
    }
}
