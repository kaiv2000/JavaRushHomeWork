package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStreamFile1 = new FileInputStream(fileName1);
        FileInputStream inputStreamFile2 = new FileInputStream(fileName2);

        byte [] file1Buffer = new byte[inputStreamFile1.available()];
        inputStreamFile1.read(file1Buffer);
        inputStreamFile1.close();

        byte [] file2Buffer = new byte[inputStreamFile2.available()];
        inputStreamFile2.read(file2Buffer);
        inputStreamFile2.close();

        FileOutputStream outputStreamFile1 = new FileOutputStream(fileName1);
        outputStreamFile1.write(file2Buffer);
        outputStreamFile1.close();

        FileOutputStream outputStreamFile1_withAppend = new FileOutputStream(fileName1, true);
        outputStreamFile1_withAppend.write(file1Buffer);
        outputStreamFile1_withAppend.close();
    }
}