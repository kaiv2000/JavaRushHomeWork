package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outpurFile = reader.readLine();
        reader.close();

        FileInputStream fileRead = new FileInputStream(inputFile);
        FileOutputStream fileWrite = new FileOutputStream(outpurFile);

        byte[] buffer = new byte[fileRead.available()];

        for (int i = fileRead.read(buffer); i > 0; i--)
        {
            fileWrite.write(buffer[i-1]);
        }
        fileRead.close();
        fileWrite.close();
    }
}