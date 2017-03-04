package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
/*

Введи с клавиатуры 5 слов в список строк.
Удали 3 - ий элемент списка
выведи оставшиеся элементы в обратном порядке.

*/


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());

        list.remove(2);

        for (int i = list.size()-1; i >= 0 ; i--)
            System.out.println(list.get(i));
    }
}
