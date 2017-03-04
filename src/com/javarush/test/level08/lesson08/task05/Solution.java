package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Petrov", "Petro");
        map.put("Petrov1", "Petro1");
        map.put("Petrov2", "Petro2");
        map.put("Petrov3", "Petro3");
        map.put("Petrov4", "Petro4");
        map.put("Petrov5", "Petro5");
        map.put("Petrov6", "Petro5");
        map.put("Petrov7", "Petro5");
        map.put("Petrov8", "Petro6");
        map.put("Petrov9", "Petro7");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,String> pair = iterator.next();
            String value = pair.getValue();
            while(iterator.hasNext())
            {
                Map.Entry<String,String> pair2 = iterator.next();
                String value2 = pair.getValue();
                if (value2.contains(value))
                iterator.remove();
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
