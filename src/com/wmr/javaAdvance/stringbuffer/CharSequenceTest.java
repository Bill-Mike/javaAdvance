package com.wmr.javaAdvance.stringbuffer;

/**
 * CharSequence 是String, StringBuffer, StringBuilder的基础接口
 */
public class CharSequenceTest {
    public static void main(String[] args) {
        String str = new String("hello world!");
        CharSequence subChar = str.subSequence(2, 5);
        System.out.println(subChar);
    }
}
