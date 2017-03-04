package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, String> calendar = new HashMap<String, String>();
        calendar.put("1", "January");
        calendar.put("2", "February");
        calendar.put("3", "March");
        calendar.put("4", "April");
        calendar.put("5", "May");
        calendar.put("6", "June");
        calendar.put("7", "July");
        calendar.put("8", "August");
        calendar.put("9", "September");
        calendar.put("10", "October");
        calendar.put("11", "November");
        calendar.put("12", "December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        for (Map.Entry<String, String> pair : calendar.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            if (input.equals(value))
                System.out.println(value + " is " + key + " month");
        }
    }
}
