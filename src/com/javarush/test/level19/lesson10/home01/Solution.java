package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader fileInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String oneLine = "";
        Map<String, Double> salaryDatabase = new TreeMap<String, Double>();

        while ((oneLine = fileInput.readLine()) != null)
        {
            String[] array = oneLine.split(" ");
            if (salaryDatabase.containsKey(array[0]))
                salaryDatabase.put(array[0], salaryDatabase.get(array[0]) + Double.parseDouble(array[1]));
            else
                salaryDatabase.put(array[0], Double.parseDouble(array[1]));
        }
        fileInput.close();

        for (Map.Entry<String, Double> pair : salaryDatabase.entrySet())
        {
            String key = pair.getKey();                      //ключ
            double value = pair.getValue();                  //значение
            System.out.println(key + " " + value);
        }
    }
}
