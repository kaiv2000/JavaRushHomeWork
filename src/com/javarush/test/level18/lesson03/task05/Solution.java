package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        List<Integer> list = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(filename);
        while (inputStream.available() > 0)
        {
            int input = inputStream.read();
            if (!(list.contains(input))) list.add(input);
        }
        inputStream.close();
        Collections.sort(list);

        for (int x : list)
        {
            System.out.print(x + " ");
        }
    }
}
