package com.guoxinan.day02.homework;

public class homework14 {
    public static void main(String[] args) {
        int year = 2025;
        boolean isLeapYear = (year%4==0 && year%100!=0)||year%400==0;

        System.out.println("今年是闰年吗?"+isLeapYear);

//        int i = 2;
//        i *= i++;
//        System.out.println(i);
//
//        int j = 2;
//        j *= j+1;
//        System.out.println(j);
//
//        int k = 2;
//        k *= ++k;
//        System.out.println(k);
//        int a = 3;
//        int b = 1;
//        if(a = b){
//            System.out.println("Equal");
//        }else {
//            System.out.println("Not Equal");
//        }
//        System.out.println(8>>>3);
//        System.out.println(8>>>3 | 2);
    }
}
