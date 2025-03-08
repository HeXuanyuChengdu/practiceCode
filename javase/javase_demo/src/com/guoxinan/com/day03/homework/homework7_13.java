package com.guoxinan.com.day03.homework;

import java.util.Scanner;

public class homework7_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput1 = 0;
        int userInput2 = 0;

        System.out.println("1到100的偶数和为:"+sumOddsFromOneToHundred());
        System.out.println("######");

        System.out.println("将开始求1到任意数的偶数和,请输入一个数:");
        userInput1 = sc.nextInt();
        System.out.printf("1到%d之间的偶数和为:%d\n",userInput1,sumOddsFromOneToAny(userInput1));
        System.out.println("#######");

        System.out.println("将开始求任意数之间的偶数和，请输入第一个数");
        userInput1 = sc.nextInt();
        System.out.println("请输入第二个数:");
        userInput2 = sc.nextInt();
        System.out.printf("%d到%d之间的偶数和是:%d\n",userInput1,userInput2,sumOddsBetween(userInput1,userInput2));
        System.out.println("########");

        System.out.println("1到100中，前5个能被5整除的数是:");
        displayTop5NumberExactDivisionBy5();
        System.out.println("########");

        System.out.println("101到200中，所有的素数有:");
        displayPrimeNumberFrom101To200();
        System.out.println("########");

        System.out.println("三位数中，是水仙花数的有:");
        displayFibonacciNumberFrom101To999();
        System.out.println("########");

        System.out.println("99乘法表为:");
        displayMultiplicationTable();


        //System.out.println(isPrime(17));
    }

    /**
     * 打印一个范围内的所有数，每5个数作为一个间隔
     *
     * @param startNumber:起始位置，从这个数开始打印
     * @param endNumber:结束位置，打印到这个数为止
     */
    public static void displayRange(int startNumber, int endNumber) {
        int count = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(i + "\t");
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
    }

    /**
     * 求各个数之间的偶数和
     *
     * @param startNumber:求偶数和的起始位置
     * @param endNumber:求偶数和的结束位置
     * @return 起始位置到结束位置的偶数之和
     */
    public static int sumOddsBetween(int startNumber, int endNumber) {
        if(startNumber > endNumber)
        {
            int temp = startNumber;
            startNumber = endNumber;
            endNumber = temp;
        }

        //如果传入的起始位置不是偶数，将其替换为startNumber到endNumber范围内离startNumber最近的偶数
        if (startNumber % 2 == 1) {
            startNumber = startNumber + 1;
            //System.out.println(startNumber);
        }
        //如果传入的起始位置不是偶数，将其替换为startNumber到endNumber范围内离startNumber最近的偶数
        if (endNumber % 2 == 1) {
            endNumber = endNumber - 1;
           // System.out.println(endNumber);
        }

        int n = (endNumber - startNumber) / 2 + 1;//根据等差数列公式计算从开始位置到结束位置一共有多少个数
        return (n * (startNumber + endNumber))/2;
    }

    /**
     * 计算1到100的偶数和
     *
     * @return 1到100的偶数和
     */
    public static int sumOddsFromOneToHundred() {
        return sumOddsBetween(1, 100);
    }

    /**
     * 计算1到任意数之间的偶数和
     *
     * @param anyNumber:任意整数，将计算1到这个整数之间的偶数和
     * @return 1到传入的参数之间的所有偶数和
     */
    public static int sumOddsFromOneToAny(int anyNumber) {
        return sumOddsBetween(1, anyNumber);
    }

    /**
     * 显示1到100中前5个能被5整除的数
     */
    public static void displayTop5NumberExactDivisionBy5() {
        int count = 0 ;   //用来计数能被5整除的数的个数
        for (int i = 1; i <= 100; i++)
        {
            if (count == 5) {
                break;
            }
            if (isExactDivisibleBy5(i))
            {
                count++;
                System.out.print(i+"\t");
            }
        }
        System.out.println();
    }

    /**
     * 判断一个数是否能被5整除
     * @param number 拿来判断的数
     * @return 若能被5整除返回true，否则返回false
     */
    public static boolean isExactDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    /**
     * 判断一个数是否是素数
     * @param number 要被判断的数
     * @return 如果是素数，返回true，否则返回false
     */
    public static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * 打印101到200之间的所有素数
     */
    public static void displayPrimeNumberFrom101To200() {
        int count = 0 ;    //计数素数个数，用来控制格式
        for (int i = 101; i <= 200; i++)
        {
            if(isPrime(i))
            {
                System.out.print(i+"\t");
                count++;
            }
            if (count == 5)
            {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }

    /**
     * 打印所有水仙花数
     */
    public static void displayFibonacciNumberFrom101To999() {
        int count = 0 ; //计数水仙花数，控制格式
        for (int i = 101; i <= 999; i++)
        {
            if (isFibonacciNumber(i))
            {
                System.out.print(i+"\t");
                count++;
            }
            if (count == 5)
            {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();

    }

    /**
     * 判断一个数是否是水仙花数
     * @param number：用来判断的数
     * @return 如果是返回true，否则返回false
     */
    public static boolean isFibonacciNumber(int number) {
        if(number > 999 || number < 100 )
        {
            System.out.println("请输入三位数");
            return false;
        }
        int hundred = number / 100;
        int ten = (number % 100) / 10;
        int one = number % 10;

        return ((Math.pow(hundred,3)+Math.pow(ten,3)+Math.pow(one,3))==number);
    }

    /**
     * 打印99乘法表
     */
    public static void displayMultiplicationTable() {
        for (int i = 1; i < 10; i++)
        {
            for (int j = 1; j < 10; j++)
            {
                System.out.print(i*j+"\t");
            }
            System.out.println();
        }
    }
}
