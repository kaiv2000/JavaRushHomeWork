package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
      public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("surname1", "name1");
        map.put("surname2", "name2");
        map.put("surname3", "name3");
        map.put("surname4", "name3");
        map.put("surname5", "name4");
        map.put("surname10", "name5");
        map.put("surname6", "name6");
        map.put("surname7", "name7");
        map.put("surname8", "name8");
        map.put("surname9", "name9");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getValue();
            if (key.equals(name))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int i = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (key.equals(lastName))
                i++;
        }
         return i;
    }
}
