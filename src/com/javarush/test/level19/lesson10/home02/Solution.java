package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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

        double maxSalary = 0;
        for (Map.Entry<String, Double> pair : salaryDatabase.entrySet())
        {
            double value = pair.getValue();                  //значение
            if (value >= maxSalary) maxSalary = value;
        }


        for (Map.Entry<String, Double> entry : salaryDatabase.entrySet())
        {
            if (entry.getValue().equals(maxSalary))
            {
                System.out.println(entry.getKey());
            }
        }
    }
}