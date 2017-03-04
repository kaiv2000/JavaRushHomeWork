package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream(filename);
        int biggest = 0;
        int current;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            current = inputStream.read(); //прочитать очередной байт
            if (current > biggest) biggest = current;
        }
        inputStream.close(); // закрываем поток

        System.out.println(biggest); //выводим сумму на экран.
    }
}
