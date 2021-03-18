package com.wmr.javaAdvance.runtime;

/**
 * RunTime类为单例设计模式，再RunTime中存放之系统资源可以通过实例化RunTime获取这些操作系统信息
 */
public class RunTimeTest {
    public static void main(String[] args) throws Exception{
        Runtime run = Runtime.getRuntime();
        System.out.println(run.availableProcessors());  //获取cpu内核数量
        System.out.println(run.maxMemory()); //获取最大可用内存信息,默认最大值为系统内存的1/4
        System.out.println(run.freeMemory()); //获取剩余内存信息
        System.out.println(run.totalMemory()); //获取内存总数量
        String str = "";
        for(int i = 0; i < 100; i++){
            str = "a" + str;
        }
        System.out.println(run.maxMemory()); //获取最大可用内存信息,默认最大值为系统内存的1/4
        System.out.println(run.freeMemory()); //获取剩余内存信息
        System.out.println(run.totalMemory()); //获取内存总数量
        System.out.println("手动gc");
        run.gc();
        Thread.sleep(2000);
        System.out.println(run.maxMemory()); //获取最大可用内存信息,默认最大值为系统内存的1/4
        System.out.println(run.freeMemory()); //获取剩余内存信息
        System.out.println(run.totalMemory()); //获取内存总数量
    }
}
