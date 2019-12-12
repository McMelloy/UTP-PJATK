package com.company;
import java.util.Scanner;
import java.util.Objects;

public class s19551 {
    public static void main(String[] args) {
        int month = 7;
        int day = 28;
        int year = 2018;
        int leapYear = (year%4==0)? 1:2;
        int counter=0;
        int dayCount;

        if(month<=8) {
            if(month>1){
                for (int i = 1; i < month; i++) {
                    if (i % 2 != 0) {
                        counter++;
                    }
                }
                if (month==2){leapYear=0;}
            }else  {leapYear=0;}

            dayCount = (--month) * 30 - leapYear + counter+day;
        }
        else {
            for (int i = 8; i < month; i++) {
                if (i % 2 == 0) {
                    counter++;
                }
            }
            System.out.println(counter);
            dayCount = (--month) * 30 - leapYear + counter+day+4; //we have 4 time 31 day in 7 months
        }

        System.out.println(dayCount);

    }
}
