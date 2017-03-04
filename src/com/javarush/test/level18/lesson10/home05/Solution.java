package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import javafx.beans.binding.NumberBinding;

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader file1ReadStream = new BufferedReader(new FileReader(fileName1));
        String currentLine;
        ArrayList<Double> numbers = new ArrayList<Double>();

        while((currentLine = file1ReadStream.readLine())!= null)
        {
            String[] allNumbers = currentLine.split(" ");
            for (int i = 0; i < allNumbers.length; i++)
            {
                numbers.add(Double.parseDouble(allNumbers[i]));
            }
        }
        file1ReadStream.close();

        BufferedWriter file2WriteStream = new BufferedWriter(new FileWriter(fileName2));
        for (Double x : numbers)
        {
            int a = (int) Math.round(x);
            file2WriteStream.write(a + " ");
        }
        file2WriteStream.close();
    }
}