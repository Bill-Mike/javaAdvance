package com.wmr.javatest;

public class ArrayTest {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        StringBuffer strb = new StringBuffer();
        for (int i: intArray) {
            strb.append(i).append(",");
        }
        System.out.println(strb.toString());

        for(int i = 0; i < intArray.length/2; i++){
            int temp = intArray[i];
            intArray[i] = intArray[intArray.length - i - 1];
            intArray[intArray.length - i - 1] = temp;
        }
        StringBuffer str = new StringBuffer();
        for (int i: intArray) {
            str.append(i).append(",");
        }
        System.out.println(str.toString());
    }
}
