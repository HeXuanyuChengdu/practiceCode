package com.guoxinan.day02.homework;

public class homework9 {
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte) (b1+b2);
        System.out.println("b3="+b3);
        short s1 = 1000;
        short s2 = 2000;
        short s3 = (short) (s1+s2);
        System.out.println("s3="+s3);
        char c1 = 'a';
        int num = 5;
        char letter = (char) (c1+num);
        //查询letter的代码单元
        String letterCodeFind = ""+letter;
        int codeOfLetter = letterCodeFind.codePointAt(0);
        System.out.println("letter="+letter);
        System.out.printf("letter code = %#x\n",codeOfLetter);
        int i1 = 5;
        int i2 = 2;
        double result = (double) i1 / i2;
        System.out.println("result="+result);

    }
}
