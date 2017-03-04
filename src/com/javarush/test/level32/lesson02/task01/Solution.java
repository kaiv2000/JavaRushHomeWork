package com.javarush.test.level32.lesson02.task01;

import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        RandomAccessFile rad = new RandomAccessFile(fileName, "rw");

        long fileSize = rad.length();
        long numberSeek = Long.valueOf(number);

        if (numberSeek > fileSize)
        {
            rad.seek(fileSize);
        }
        else
        {
            rad.seek(numberSeek);
        }
        rad.writeBytes(text);
        rad.close();
    }
}
