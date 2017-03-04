package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(5.5, "1");
        labels.put(55.4, "17");
        labels.put(52.5, "16");
        labels.put(56.5, "14");
        labels.put(57.5, "31");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
