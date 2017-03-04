package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        for (int i = 0; i < 10; i++)
        {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);

        for (int j = 0; j < result.size(); j++)
        {
            System.out.println(result.get(j));
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.add(i, list.get(i));
            i++;
        }
        return list;
    }
}
