package com.guoxinan.com.day03.practice;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        System.out.println("1到10的数：");
        displayOneToTen();
        System.out.println("#####");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意一个数，将打印1到这个数的所有数:");
        int any = sc.nextInt();
        displayOneToAny(any);
        System.out.println("#####");

        System.out.println("将显示任意两个数之间的所有数，请输入第一个数:");
        int first = sc.nextInt();
        System.out.println("请输入第二个数:");
        int second = sc.nextInt();
        displayNumberToAny(first, second);
        System.out.println("#####");

        System.out.println("将开始对1到100求和");
        System.out.println("1到100的和为:"+sumOneToHundred());
        System.out.println("#####");

        System.out.println("将开始对1到任意数求和，请输入要求和的数:");
        System.out.println(""+sumOneToAnyNumber(sc.nextInt()));
        System.out.println("#####");

        System.out.println("将开始计算任意数的求和，请输入求和的开始范围:");
        first = sc.nextInt();
        System.out.println("请输入求和的截止范围:");
        second = sc.nextInt();
        System.out.printf("%d到%d的和为:%d",first,second, sumFirstNumberToSecondNumber(first,second));
    }

    /**
     * 打印1到10
     */
    public static void displayOneToTen() {
        displayRange(1,10);
    }

    /**
     * 打印1到任意值的数
     * @param anyNumber：作为截止范围，从1开始
     */
    public static void displayOneToAny(int anyNumber) {
        displayRange(1,anyNumber);
    }

    /**
     * 打印用户输入的任何范围的数
     * @param firstNumber:打印数的开始范围
     * @param endNumber:打印书的截止范围
     */
    public static void displayNumberToAny(int firstNumber,int endNumber) {
        //保证按照从小到大的顺序传递参数
        if(firstNumber > endNumber)
        {
            int temp = firstNumber;
            firstNumber = endNumber;
            endNumber = temp;
        }

        displayRange(firstNumber,endNumber);
    }

    /**
     *
     * @return sum:1到100的和
     */
    public static int sumOneToHundred() {
        int sum ;
        sum = (100/2) * (1+100);
        return sum;
    }

    /**
     *求1到任意数的和
     * @param anyNumber:求和的任意数
     * @return 1到任何数的和
     */
    public static int sumOneToAnyNumber(int anyNumber) {
        //等差数列求和
        return (anyNumber/2) * (1+anyNumber);
    }

    /**
     * 求任意数的和
     * @param firstNumber：求和范围的第一个数
     * @param endNumber：求和范围的截止数
     * @return 求和结果
     */
    public static int sumFirstNumberToSecondNumber(int firstNumber, int endNumber) {
        //保证传入参数的大小顺序
        if(firstNumber > endNumber)
        {
            int temp = firstNumber;
            firstNumber = endNumber;
            endNumber = temp;
        }

        return ((endNumber-firstNumber+1)/2) * (firstNumber+endNumber);
    }

    /**
     * 打印一个范围内的数
      * @param startNumber：从这个数开始打印
     * @param endNumber：到这个数结束
     */
    public static void displayRange(int startNumber,int endNumber) {
        int count = 0 ;  //控制格式的计数器
        for(int i=startNumber;i<=endNumber;i++)
        {
            System.out.print(i+"\t");
            count++;
            if (count>=5)
            {
                System.out.println();
                count=0;
            }
        }
        System.out.println();
    }
}
