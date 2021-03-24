package com.wmr.javaAdvance.filestream;

import java.io.*;

/**
 * 字节流与字符流互相转换测试
 */
public class ByteStream2CharStreamTest {
    public static void main(String[] args) {
        File file = new File("D:\\数据文件\\EM_TXT\\test.txt");
        if(! file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            OutputStream outputStream = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outputStream);
            writer.append("Hello world!!!!!!!!!!!");
            writer.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
