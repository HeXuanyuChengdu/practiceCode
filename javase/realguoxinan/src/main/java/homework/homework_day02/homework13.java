package com.guoxinan.day02.homework;

public class homework13 {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        int z = 300;

        int max = x>y?x:y;
        max = max>z?max:z;
        System.out.println("x,y,z中最大的值为:"+max);
    }
}
