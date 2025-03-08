package com.guoxinan.day02.homework;

public class homework6 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换前，a="+a+",b="+b);

        int temp = b;
        b=a;
        a=temp;

        System.out.println("交换后,a="+a+",b="+b);
    }
}
