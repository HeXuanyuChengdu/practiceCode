package com.chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {

    enum Title {Mon,Tue,Wed,Thu,Fri,Sat,Sun};

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        //buildCalendar(today);

        date = date.minusDays(today-1);
        int weekvalue = date.getDayOfWeek().getValue();
        System.out.println(weekvalue);

        System.out.println("Mon Tue Wed Thu Sat Sun");
        //保证打印从星期一到今天之前对齐的缩进
        for(int i = 1; i < weekvalue; i++)
        {
            System.out.print("aaa ");
        }

        while (date.getMonthValue() == month)
        {
            //控制字符宽度为3且右对齐
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today)
            {
                System.out.print("*");
            }else {
                System.out.print("#");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)
            {
                System.out.println();
            }
        }


    }






}
