package com.wmr.javaAdvance.filestream;

import com.sun.scenario.animation.shared.ClipEnvelope;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * jdk1.9之后InputStream类中又一个transferTo()方法将文件转存
 */
public class FileCopyTest {
    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("参数不正确，请输入目标文件与生成文件");
            System.exit(1);
        }

        long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(args[0], args[1]);
        System.out.println(fileUtil.copy() ? "操作成功" : "操作失败");
        long end = System.currentTimeMillis();
        System.out.println("操作完成使用时间" + (end - start) + "毫秒");
    }
}

class FileUtil{
    private File srcFile;
    private File desFile;
    public FileUtil(File src, File des){
        this.srcFile = src;
        this.desFile = des;
    }
    public FileUtil(String src, String des){
        this(new File(src), new File(des));
    }

    public boolean copy(){
        boolean result = false;
        if (!this.srcFile.exists()){
            System.out.println("源文件路径不正确");
        }
        if(!this.desFile.getParentFile().exists()){
            this.desFile.getParentFile().mkdirs();
        }

        byte[] data = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(this.srcFile);
            outputStream =new FileOutputStream(this.desFile);
            int len = 0;
            while (len != -1){
                len = inputStream.read(data);
                if(len != -1){
                    outputStream.write(data,0,len);
                }
            }
            result = true;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
