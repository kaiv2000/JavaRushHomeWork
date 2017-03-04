package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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
        int index = 0;
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int oneByte = inputStream.read(); // прочитать очередной байт в переменную data
            index++;
            if (index % 2 == 0 ) outputStream.write(oneByte); // и записать его во второй поток
        }
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
