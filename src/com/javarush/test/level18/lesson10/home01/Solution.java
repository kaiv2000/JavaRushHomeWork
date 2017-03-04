package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputFile = new FileInputStream(args[0]);
        int quanity = 0;
        while (inputFile.available() > 0)
        {
            int input = inputFile.read();
            if (input > 64 && input < 91 || input > 96 && input < 123)
            quanity++;
        }
        System.out.println(quanity);
        inputFile.close();

    }
}
