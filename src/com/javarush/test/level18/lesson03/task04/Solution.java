package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0)
        {
            int currentKey = inputStream.read();
            if (map.containsKey(currentKey))
            {
                int keysQuantity = map.get(currentKey);
                map.put(currentKey, ++keysQuantity);
            }
            else map.put(currentKey, 1);
        }

        int minbyte = 1;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() < minbyte) minbyte = pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue().equals(minbyte)) System.out.print(pair.getKey() + " ");
        }
    }
}
