package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String newInput = input.substring(input.indexOf('?')+1);

        String[] singleParametr = newInput.split("&|\\?");

        String keyFull = "";
        String key = "";
        ArrayList<String> values = new ArrayList<String>();

        for (int i = 0; i <= singleParametr.length-1; i++)
        {
            keyFull = singleParametr[i];

            if (keyFull.equals("") || singleParametr.length == 1) //skip ?& and &&
            {
                continue;
            }

            if (keyFull.contains("="))
            {
                int divider = singleParametr[i].lastIndexOf('=');
                key = singleParametr[i].substring(0, divider);
                values.add(keyFull);
                System.out.print(key + " ");
            }

            else if (!(keyFull.contains("=")))
            {
                values.add(keyFull);
                System.out.print(keyFull + " ");
            }
        }

        System.out.println("");

        for (String i : values)
        {
            if (i.contains("="))
            {
                int divider = i.lastIndexOf('=');
                key = i.substring(0, divider);
                int end = i.length();
                if (key.equals("obj"))
                {
                    try
                    {
                        alert(Double.parseDouble(i.substring(divider+1, end)));
                    }
                    catch (NumberFormatException e)
                    {
                        alert(i.substring(divider+1, end));
                    }
                }
            }

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }
    public static void alert(String value) {
        System.out.println("String " + value);
    }
}