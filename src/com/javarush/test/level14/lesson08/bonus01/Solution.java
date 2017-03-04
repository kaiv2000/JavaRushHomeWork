package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

        try
        {
            FileInputStream fis = new FileInputStream("C2:\\badFileName.txt");
        }
        catch (FileNotFoundException e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            String m = s.toLowerCase();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] m = new int[2];
            m[8] = 5;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        }

        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        }

        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            float i = 10 / 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(55);
        }

        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            String m = s.toUpperCase();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream fis = new FileInputStream("C:\\Name.txt");
        }
        catch (FileNotFoundException e)
        {
            exceptions.add(e);
        }

    }


}