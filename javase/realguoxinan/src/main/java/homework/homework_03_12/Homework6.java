package main.java.homework.homework_03_12;

import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        System.out.println("😊猜数游戏开始,请输入一个0~20范围内的数:");
        int userInput = handleUserInput();
        A game = new A(0);
        while (game.value() != userInput) {
            if (game.value() > userInput) {
                System.out.println("您猜的数小啦~");

            }else{
                System.out.println("您猜的数大啦~");
            }
            System.out.println("请重新输入:");
            userInput = handleUserInput();
        }
        System.out.println("恭喜您，猜中啦!🎉");

    }

    /**
     * 处理用户的输入，避免非数值类型的输入
     * @return
     */
    public static int handleUserInput() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("输入有误!请输入一个整数");
        }
        return sc.nextInt();
    }

}

/**
 * 一个{@code A}记录专门用于进行0~20范围内的猜数游戏
 * A记录的value字段表示要猜的目标
 */
record A(int value){
    public A(int value){
        //this(value);
        this.value = (int)(Math.random()*21);
    }

}