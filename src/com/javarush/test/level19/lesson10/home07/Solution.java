package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileInput = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        FileWriter fileOutput = new FileWriter(args[1]);
        ArrayList<String> list = new ArrayList<String>();
        String oneLine = "";
        while ((oneLine = fileInput.readLine()) != null)
        {
            String[] oneLineData = oneLine.split(" ");
            for (int i = 0; i <= oneLineData.length - 1; i++)
            {
                String oneWord = oneLineData[i];
                if (oneWord.length() > 6)
                {
                    list.add(oneWord);
                }
            }
        }
        fileInput.close();

        for (int i = 0; i <= list.size() - 1; i++)
        {
            if (i < list.size() - 1)  fileOutput.write(list.get(i) + ",");
            else fileOutput.write(list.get(i));
        }
        fileOutput.close();
    }
}