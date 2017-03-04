package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        int currentByte;
        FileInputStream inputStreamFile2 = new FileInputStream(file2);
        FileOutputStream outputStreamFile1 = new FileOutputStream(file1, true);
        while (inputStreamFile2.available() > 0)
        {
            currentByte = inputStreamFile2.read();
            outputStreamFile1.write(currentByte);
        }
        inputStreamFile2.close();

        FileInputStream inputStreamFile3 = new FileInputStream(file3);
        while (inputStreamFile3.available() > 0)
        {
            currentByte = inputStreamFile3.read();
            outputStreamFile1.write(currentByte);
        }
        inputStreamFile3.close();
        outputStreamFile1.close();
    }
}
