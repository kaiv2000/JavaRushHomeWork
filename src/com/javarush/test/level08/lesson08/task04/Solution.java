package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallon", new Date("JULY 1 1980"));
        map.put("Stallo", new Date("AUGUST 1 1980"));
        map.put("Stallon1", new Date("May 1 1980"));
        map.put("Stallone2", new Date("OCTOBER 1 1980"));
        map.put("Stallone3", new Date("NOVEMBER 1 1980"));
        map.put("Stallone4", new Date("DECEMBER 1 1980"));
        map.put("Stallon5", new Date("FEBRUARY 1 1980"));
        map.put("Stallone6", new Date("APRIL 1 1980"));
        map.put("Stallone7", new Date("MAY 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,Date> pair = iterator.next();
            Date value = pair.getValue();
            int rad = value.getMonth();
            if(rad == 5 || rad == 6 || rad == 7)
                iterator.remove();
            System.out.println(pair);
        }
    }
}
