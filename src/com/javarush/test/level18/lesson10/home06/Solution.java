package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStream in = new FileInputStream(args[0]);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (true)
        {
            int oneByte = in.read();
            if (oneByte != -1)
            {
                if (map.containsKey(oneByte))
                {
                    int currentKey = map.get(oneByte);
                    map.put(oneByte, ++currentKey);
                }
                else
                {
                    map.put(oneByte, 1);
                }
            }
            else break;
        }

        Map<Integer, Integer> newmap = new TreeMap<Integer, Integer>(map);

        for (Map.Entry<Integer, Integer> pair : newmap.entrySet())
        {
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char) key + " " +value);
        }



    }
}
