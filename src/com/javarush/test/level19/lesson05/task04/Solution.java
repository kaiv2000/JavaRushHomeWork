package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int oneByte = inputStream.read(); // прочитать очередной байт в переменную data
            if (oneByte == 46) outputStream.write(33);
            else outputStream.write(oneByte);
        }
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
