package com.guoxinan.day02.homework;

public class homework4 {
    public static void main(String[] args) {
        byte numberMinByte = Byte.MIN_VALUE;
        byte numberMaxByte = Byte.MAX_VALUE;
        System.out.println("byte范围最小值为:"+numberMinByte+",最大值为"+numberMaxByte);

        short negativeNumberBelongShort = -200;
        short positiveNumberBelongShort = 200;
        System.out.println("属于short范围的数有"+negativeNumberBelongShort+"和"+positiveNumberBelongShort);

        int negativeNumberBelongInt = -50000;
        int positiveNumberBelongInt = 50000;
        System.out.println("属于int范围的数有"+negativeNumberBelongInt+"和"+positiveNumberBelongInt);

        long negativeNumberBelongLong = -3000000000L;
        long positiveNumberBelongLong = 3000000000L;
        System.out.println("属于long型的数有"+negativeNumberBelongLong+"和"+positiveNumberBelongLong);
    }
}

