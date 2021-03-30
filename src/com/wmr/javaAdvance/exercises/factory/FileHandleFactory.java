package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.service.IFileOperationService;
import com.wmr.javaAdvance.exercises.service.impl.FileOperationServieImpl;

public class FileHandleFactory {
    private FileHandleFactory(){}
    public static IFileOperationService getInstance(){
        return new FileOperationServieImpl();
    }
}
