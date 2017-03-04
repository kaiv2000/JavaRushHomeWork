package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        int j = 0;
        int jmax = 0;



        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++)
        {
            String s = reader.readLine();
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++)
        {
            j = list.get(i).length();
            if (jmax < j)
                jmax = j;
        }

        for (int z = 0; z < list.size(); z++)
        {
            if (jmax == list.get(z).length())

                System.out.println(list.get(z));
        }
    }
}
