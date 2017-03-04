package com.javarush.test.level09.lesson11.home03;

/* Метод в try..catch
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
Обернуть все тело (весь код внутри readData, кроме объявления списка, где будут храниться числа и BufferedReader - а) этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и вывести на экран все введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        readData();
    }

    public static void readData()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();

        try
        {
            while (true)
            {
                int m = Integer.parseInt(reader.readLine());
                Object obj = m;
                list.add(m);

                if (!(obj  instanceof Integer))
                {
                    return;
                }

            }
        }

        catch (Exception e)
        {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext())
            {
                Integer text = iterator.next();
                System.out.println(text);
            }
        }
    }
}
