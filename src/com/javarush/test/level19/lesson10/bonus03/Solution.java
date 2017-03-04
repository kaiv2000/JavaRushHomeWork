package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String searchedTag = args[0];

        BufferedReader fileInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String oneLine = "";
        StringBuffer all = new StringBuffer();
        while ((oneLine = fileInput.readLine()) != null)
        {
            all.append(oneLine);
        }
        fileInput.close();

        String allText = all.toString();

        findTags(searchedTag, allText, 0);
    }

    private static void findTags(String searchedTag, String allString, int indexOut)
    {
        int howManyTag = 0, lastTagsIndex = 0, index = indexOut;

        while (index < (allString.length() - searchedTag.length() - 1))
        {
            if (allString.substring(index, index + searchedTag.length() + 1).equals("<" + searchedTag))
            {
                if (howManyTag == 0) lastTagsIndex = index;
                howManyTag++;
            }
            else if (allString.substring(index, index + searchedTag.length() + 2).equals("</" + searchedTag))
            {
                howManyTag--;
                if (howManyTag == 0)
                {
                    String newString = allString.substring(lastTagsIndex, index + searchedTag.length() +3);
                    System.out.println(newString);
                    findTags(searchedTag, newString, 1);
                }
            }
            index++;
        }
    }
}
