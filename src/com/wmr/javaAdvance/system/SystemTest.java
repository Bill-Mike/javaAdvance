package com.wmr.javaAdvance.system;

import java.util.Date;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date());
    }
}
