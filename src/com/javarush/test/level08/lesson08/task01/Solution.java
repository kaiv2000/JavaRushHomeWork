package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(createSet());
    }

    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Лапа");
        set.add("Ла");
        set.add("Лапаa");
        set.add("Лапаaa");
        set.add("Лапаaaa");
        set.add("Лапаaaaa");
        set.add("Лапаdfdf");
        set.add("Лапdfxcvcxvа");
        set.add("Лапаvcxvcx");
        set.add("Лапаxcvxcv");
        set.add("Лапcvbvcbа");
        set.add("Лаvbnbvnпа");
        set.add("Лапbvnvb а");
        set.add("Ла   па");
        set.add("Лапvbnbvnа");
        set.add("Лаbnbvnпа");
        set.add("Лаytuytuпа");
        set.add("Ла567567па");
        set.add("Ла6765па");
        set.add("Лапtyutyuа");
        return set;
    }
}
