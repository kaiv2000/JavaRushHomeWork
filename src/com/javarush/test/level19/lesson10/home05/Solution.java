package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        FileWriter fileOutput = new FileWriter(fileName2);


        String oneLine = "";
        while ((oneLine = fileInput.readLine()) != null)
        {
            String[] oneLineData = oneLine.split(" ");

            for (int i = 0; i <= oneLineData.length - 1; i++)
            {
                if (oneLineData[i].matches(".*\\d+.*")) fileOutput.write(oneLineData[i] + " ");
            }
        }
        fileInput.close();
        fileOutput.close();
    }
}
