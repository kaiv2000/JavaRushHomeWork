package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static Map<Integer,String> map = new HashMap<Integer, String>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNextLine())
        {

            String s = scanner.nextLine();      //читаем всю строку в файле
            String[] array = s.split(" ");      // делим строку на массив по пробелу

            //0 элемент массива приводим в Integer и добавляем в map, как пары Id : String
            Integer id = Integer.parseInt(array[0]);
            map.put(id, s);
        }

        for (Map.Entry<Integer,String> pair : map.entrySet())
        {
            Integer choice = Integer.parseInt(args[0]);     //Указанный параметр
            Integer index = pair.getKey();

            if (choice.equals(index))
            {
                System.out.println(pair.getValue());
            }
        }

        reader.close();
        scanner.close();
    }
}
