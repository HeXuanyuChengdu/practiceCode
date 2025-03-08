package com.guoxinan.day02.homework;

public class homework12 {
    public static void main(String[] args) {
        int week = 2;
        int weekAfter100Days = (week+100)%7;

        String whichweek = switch (weekAfter100Days){
            case 1,2,3,4,5,6 -> String.format("今天是周%d",weekAfter100Days);
            case 7 -> "今天是周天";
            default -> "???";
        };
        System.out.println(whichweek);
    }
}
