package com.guoxinan.day02.homework;

import java.util.Scanner;

public class homework20 {
    public static void main(String[] args) {
        //产生随机数代表中将号码
        int winnerNumber = 1000+(int)(Math.random()*9000);
        int userNumber ;
        boolean isWinner = false;

        while (!isWinner)
        {
            System.out.print("请输入您要抽取的号码:");
            Scanner in = new Scanner(System.in);
            userNumber = in.nextInt();
            int hundredOfUserNumber = (userNumber / 100) % 10;
            int hundredOfWinner = (winnerNumber / 100) % 10;
            if (hundredOfWinner == hundredOfUserNumber)
            {
                System.out.println("恭喜您，中奖啦!😊");
                isWinner = true;
            }else {
                System.out.println("很遗憾，没有中奖品哦😔");
            }
        }
    }
}
