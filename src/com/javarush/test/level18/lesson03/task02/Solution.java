package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
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
        int smallest =inputStream.read();
        int current;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            current = inputStream.read(); //прочитать очередной байт

            if (current < smallest) smallest = current;
        }
        inputStream.close(); // закрываем поток

        System.out.println(smallest); //выводим сумму на экран.
    }
}
