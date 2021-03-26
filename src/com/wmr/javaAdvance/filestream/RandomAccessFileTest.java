package com.wmr.javaAdvance.filestream;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\test\\nohup.out");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw"); //r 读模式， w写模式
//        String[] names = new String[]{"zhangsan", "lisi", "wangwu"};
//        int[] ages = new int[]{30,20, 10};
//        for(int i = 0; i < ages.length; i++){
//            randomAccessFile.write(names[i].getBytes());
//            randomAccessFile.writeInt(ages[i]);
//        }
        System.out.println("start time");
        long start = System.currentTimeMillis();
        System.out.println(start);
        randomAccessFile.seek(10000);
        //randomAccessFile.skipBytes(10000);
        byte[] data = new byte[1024];
        randomAccessFile.read(data);
        System.out.println(new String(data));
        System.out.println("end time");
        long endtime = System.currentTimeMillis();
        System.out.println(endtime);
        System.out.println("use time");
        System.out.println(endtime -start);

        System.out.println(randomAccessFile.length());
        
        for(int i = 0; i < 100; i ++){
            System.out.println(new String(new char[]{(char) randomAccessFile.readByte()}));
        }

        randomAccessFile.close();
    }
}
