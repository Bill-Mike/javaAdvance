package com.wmr.javatest.staticImport;

/**
 * 事实证明还是带类名的讲台方法好用
 */

import static com.wmr.javatest.staticImport.Math1.*;
import static com.wmr.javatest.staticImport.Math2.*;
public class StaticImportTest {
    public static void main(String[] args) {
        System.out.println(Math1.add(10, 20));
    }
}
