package com.wmr.javaAdvance.filestream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/*
 * Constructs a FileWriter object given a File object. If the second
 * argument is <code>true</code>, then bytes will be written to the end
 * of the file rather than the beginning.
 *
 * @param file  a File object to write to
 * @param     append    if <code>true</code>, then bytes will be written
 *                      to the end of the file rather than the beginning
 * @throws IOException  if the file exists but is a directory rather than
 *                  a regular file, does not exist but cannot be created,
 *                  or cannot be opened for any other reason
 * @since 1.4
 * public FileWriter(File file, boolean append) throws IOException {
 *         super(new FileOutputStream(file, append));
 *     }
 */
public class WriterTest {
    public static void main(String[] args) {
        File file = new File("D:\\数据文件\\EM_TXT\\test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs(); //保证父目录一定存在
        }
        Writer writer = null;
        try {
            writer = new FileWriter(file,true); //使用append（）方法时后面添加true
            String data = "就拉萨看得见芬兰你，都上放了哪里努力看书的妇女ccccccccccc";
            writer.append(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
