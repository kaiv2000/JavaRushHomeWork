package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        String line = "";
        int count = 0;
        while( (line = in.readLine()) != null)
        {
            String replacedString = line.replaceAll("\\p{P}"," ");
            String[] wordArray = replacedString.split(" ");
            for (int i = 0; i <= wordArray.length - 1; i++)
            {
                if (wordArray[i].equals("world"))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
        in.close(); //закрываем оба потока. Они больше не нужны.
    }
}
