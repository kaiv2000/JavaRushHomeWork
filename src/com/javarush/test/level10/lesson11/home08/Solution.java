package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] list = new ArrayList[3];
        ArrayList<String> listinsert = new ArrayList<String>();
        ArrayList<String> listinsert1 = new ArrayList<String>();
        ArrayList<String> listinsert2 = new ArrayList<String>();

        listinsert.add("Mama");
        listinsert1.add("Mila");
        listinsert2.add("Ramu");

        list[0] = listinsert;
        list[1] = listinsert1;
        list[2] = listinsert2;

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}