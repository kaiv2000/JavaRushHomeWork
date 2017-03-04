package com.javarush.test.level06.lesson11.bonus03;

import com.sun.security.auth.SolarisNumericUserPrincipal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int [] mas = new int[5];
        for (int i=0;i<mas.length;i++)
        {
            mas[i]=Integer.parseInt(reader.readLine());
        }

        //цикл для прогону n=5 раз
        for (int j=0;j<mas.length;j++)
        {
            //прогін одної цифри з початку до кінця
            for (int i = 1; i<mas.length;i++)
            {
                int z=0;
                if (mas[i]<mas[i-1])
                {
                    z=mas[i];
                    mas[i]=mas[i-1];
                    mas[i-1]=z;

                }

            }
        }
        for (int i=0;i<mas.length;i++)
        {
            System.out.println(mas[i]);

        }
    }

}