package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputFile = new FileInputStream(args[0]);
        int allSymbolsQuantity = 0;
        int spacebarQuantity = 0;
        float ratio = 0;
        while (inputFile.available() > 0)
        {
            int currentSymbol = inputFile.read();
            allSymbolsQuantity++;
            if (currentSymbol == 32) spacebarQuantity++;
        }
        ratio = (float)spacebarQuantity / allSymbolsQuantity*100;
        System.out.println(String.format("%.2f", ratio));
        inputFile.close();
    }
}
