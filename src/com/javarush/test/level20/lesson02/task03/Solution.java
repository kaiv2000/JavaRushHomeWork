package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<String, String>();

    public static void main(String[] args) throws IOException
    {

    }

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        load(new FileInputStream(reader.readLine()));

    }

    public void save(OutputStream outputStream) throws Exception
    {

        Properties myProperties = new Properties();

        PrintWriter writer = new PrintWriter(outputStream);

        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            myProperties.put(key, value);
        }
        myProperties.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties myProperties = new Properties();

        myProperties.load(inputStream);
        for (String x : myProperties.stringPropertyNames())
        {
            properties.put(x, myProperties.getProperty(x));
        }

    }
}
