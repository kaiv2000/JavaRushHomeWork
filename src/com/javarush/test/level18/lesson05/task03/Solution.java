package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename);
        FileOutputStream outputStream1 = new FileOutputStream(filename2);
        FileOutputStream outputStream2 = new FileOutputStream(filename3);

        byte[] buffer = new byte[inputStream.available()];

        while (inputStream.available() > 0)
        {
            int bytesCount = inputStream.read(buffer);
            int outputStream1Length3 = bytesCount/2;
            int outputStream1Length2 = bytesCount - outputStream1Length3;
            outputStream1.write(buffer, 0, outputStream1Length2);
            outputStream2.write(buffer, outputStream1Length2, outputStream1Length3);
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}