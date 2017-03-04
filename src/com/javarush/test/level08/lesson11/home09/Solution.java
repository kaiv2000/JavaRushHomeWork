package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        Date data = new Date();
        SimpleDateFormat Dataformat = new SimpleDateFormat("MMMM dd yyyy", Locale.US);
        String date = Dataformat.format(data).toUpperCase();
        System.out.println(date);
        isDateOdd(date);
        Date first = Dataformat.parse(date);
        System.out.println(first);
        System.out.println(isDateOdd(date));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        SimpleDateFormat formater = new SimpleDateFormat("MMMM d yyyy", Locale.US);
        Date first = formater.parse(date);
        Date second = new Date();
        long distance = second.getTime() - first.getTime();
        int pri = 24 * 60 * 60 * 1000;
        int dateCount = (int) (distance / pri);

        if (dateCount % 2 == 0)
        {
            return true;
        } else
        {
            return false;
        }

    }
}