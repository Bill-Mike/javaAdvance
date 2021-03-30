package com.wmr.javaAdvance.exercises.service;

import java.io.File;

public interface IFileOperationService {

    public static final String SAVE_DIR = "D:" + File.separator + "test\\1111" + File.separator;  //设置文件存储目录
    /**
     *
     * @return
     */
    public boolean save();
}
