package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        int[] array = new int[10];

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }


        for (int left = 0, right = array.length - 1; left < right; left++, right--)
        {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
