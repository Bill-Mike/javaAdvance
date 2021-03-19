package com.wmr.javaAdvance.resourcebundle;

import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle("com.wmr.javaAdvance.resourcebundle.test");
        String value = res.getString("test");
        System.out.println(value);
    }
}
