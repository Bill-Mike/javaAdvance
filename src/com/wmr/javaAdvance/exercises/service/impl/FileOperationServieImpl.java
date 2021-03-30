package com.wmr.javaAdvance.exercises.service.impl;

import com.wmr.javaAdvance.exercises.service.IFileOperationService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

import java.io.*;

public class FileOperationServieImpl implements IFileOperationService {
    private String name;
    private String content;

    public FileOperationServieImpl(){
        this.name = InputUtil.getString("请输入保存文件的名称");
        this.content = InputUtil.getString("请输入保存文件的内容！");
    }
    @Override
    public boolean save() {
        File file = new File(IFileOperationService.SAVE_DIR + this.name);
        PrintWriter out = null;
        boolean result = false;
        try {
            out = new PrintWriter(new FileWriter(file));
            out.print(this.content);
            out.write(this.content);
            out.flush();
            result = true;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return result;
        }catch (IOException e){
            e.printStackTrace();
            return result;
        } finally{
            if (out != null){
                out.close();
            }
        }
        return result;
    }
}
