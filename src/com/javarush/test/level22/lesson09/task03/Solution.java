package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/

public class Solution {

    static ArrayList<String> listWords = new ArrayList<>();


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String onestring;
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
        while ((onestring = inputStream.readLine())!=null)
        {
            String[] oneStringWords = onestring.split(" ");
            for (String x : oneStringWords){
             listWords.add(x);
            }
        }
        inputStream.close();

        String[] allWords = new String[listWords.size()];
        allWords = listWords.toArray(allWords);

        StringBuilder result = getLine(allWords);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if (words == null || words.length == 0)
        { return new StringBuilder(); }
        if ("".equals(words[0]) || words.length == 1)
        {return new StringBuilder(words[0]); }

        StringBuilder sb = new StringBuilder();

        sb.append(listWords.get(0)).append(" ");
        listWords.remove(0);
        int listSize = listWords.size();

        for (int i = 0; i < listSize; i++)
        {

            Iterator<String> it = listWords.iterator();

            while (it.hasNext())
            {
                String x = it.next();
                String lastLetter = String.valueOf(sb.charAt(sb.length() - 2));

                if (x.toUpperCase().toLowerCase().startsWith(lastLetter.toUpperCase().toLowerCase()))
                {
                    sb.append(x).append(" ");
                    it.remove();
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb;
    }
}
