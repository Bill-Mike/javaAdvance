package com.wmr.javaAdvance.resourcebundle;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        Locale locale = new Locale("zh_CN");
        ResourceBundle res = ResourceBundle.getBundle("com.wmr.javaAdvance.resourcebundle.test",locale);
        String value = res.getString("test");
        System.out.println(value);
        value = res.getString("info");
        System.out.println(MessageFormat.format(value,"Bill", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
    }
}
