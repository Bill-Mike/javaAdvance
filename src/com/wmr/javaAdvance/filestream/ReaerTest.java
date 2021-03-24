package com.wmr.javaAdvance.filestream;

import java.io.*;

/**
 * 与Writer方法类似
 */
public class ReaerTest {
    public static void main(String[] args) {
        File file = new File("D:\\数据文件\\EM_TXT\\test.txt");
        if(! file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        Reader reader = null;
        try {
            reader = new FileReader(file);
            char[] data = new char[1024];
            int len = reader.read(data);
            System.out.println(new String(data, 0 ,len));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                file.getParentFile();
            }
        }
    }
}
