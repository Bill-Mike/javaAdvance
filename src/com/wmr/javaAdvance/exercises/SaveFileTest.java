package com.wmr.javaAdvance.exercises;

import com.wmr.javaAdvance.exercises.factory.FileHandleFactory;
import com.wmr.javaAdvance.exercises.service.IFileOperationService;

import java.io.File;

/**
 * 保存文件测试类
 */
public class SaveFileTest {

    static {    //静态代码块类加载时执行，保证程序运行时文件存储目录存在
        File file = new File(IFileOperationService.SAVE_DIR);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    public static void main(String[] args) {
        IFileOperationService service = FileHandleFactory.getInstance();
        System.out.println(service.save());
    }
}
