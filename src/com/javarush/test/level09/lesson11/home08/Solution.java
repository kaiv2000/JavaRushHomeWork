package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.List;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]>list = new ArrayList<int[]>();

        int[] list1 = new int[5];
        int[] list2 = new int[2];
        int[] list3 = new int[4];
        int[] list4 = new int[7];
        int[] list5 = new int[0];

        list1[0] = 1;
        list1[1] = 1;
        list1[2] = 1;
        list1[3] = 1;
        list1[4] = 1;

        list2[0] = 1;
        list2[1] = 1;

        list3[0] = 1;
        list3[1] = 1;
        list3[2] = 1;
        list3[3] = 1;

        list4[0] = 1;
        list4[1] = 1;
        list4[2] = 1;
        list4[3] = 1;
        list4[4] = 1;
        list4[5] = 1;
        list4[6] = 1;

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
