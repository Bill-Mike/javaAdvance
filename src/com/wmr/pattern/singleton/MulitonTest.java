package com.wmr.pattern.singleton;

/**
 * 多例设计模式
 */
public class MulitonTest {
    private static MulitonTest red = new MulitonTest("红色");
    private static MulitonTest green = new MulitonTest("绿色");
    private static MulitonTest blue = new MulitonTest("蓝色");
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    private MulitonTest(String color){
        this.color = color;
    }

    public static MulitonTest getInstance(String color){
        switch (color){
            case "red":
                return red;
            case "green":
                return green;
            case "blue":
                return blue;
            default:
                return null;

        }

    }

    public static void main(String[] args) {
        MulitonTest red = MulitonTest.getInstance("red");

        MulitonTest green = MulitonTest.getInstance("green");

        MulitonTest blue = MulitonTest.getInstance("blue");
        System.out.println(blue.getColor());
        System.out.println(green.getColor());
        System.out.println(red.getColor());
    }

}
