package com.wmr.javaAdvance.filestream;

import java.io.*;

public class OutputStreamTest {
    /*
    因为FileOutputStream继承了AutoCloseable接口所以与try..catch同用自动关闭输出流
     */
    public static void main(String[] args) {
        File file = new File("D:\\数据文件\\EM_TXT\\test.txt");
        if(!file.getParentFile().exists()){ //如果指定文件不存在
            file.getParentFile().mkdirs();  //创建父目录
        }
        try (OutputStream outputStream = new FileOutputStream(file)){
            String data = "hello world!";
            outputStream.write(data.getBytes());
        }catch (FileNotFoundException e){
            System.out.println("未发现指定文件");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }

    }
}
