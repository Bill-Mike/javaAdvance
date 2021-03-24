package com.wmr.javaAdvance.filestream;

import java.io.*;

/**
 * public abstract int read() throws IOException; 返回-1时表示文件已经读取到最后，不是-1是返回的是文件中字节具体数值
 *
 * jdk1.9之后添加了getAllBytes() 获取文件所有内容，当读取文件很大时容易耗尽内存，不推荐使用
 */
public class InputStreamTest {
    public static void main(String[] args) {
        File file = new File("D:\\数据文件\\EM_TXT\\test.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[1024];   //开辟一个存放读取数据的字节数组
            int len = inputStream.read(data);   //获取读取字节数组的长度
            System.out.println("[" + new String(data, 0, len) +"]");    //防止data[]数组的空值占位
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
