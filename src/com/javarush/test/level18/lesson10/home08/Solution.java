package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";

        while(!(fileName = reader.readLine()).equals("exit"))
            {
                new ReadThread(fileName).start();
            }
        reader.close();
    }

    public static class ReadThread extends Thread
    {
        String fileName;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        public void run()
        {
            try
            {
                InputStream in = new FileInputStream(fileName);
                while (true)
            {
                int oneByte = in.read();
                if (oneByte != -1)
                {
                    if (map.containsKey(oneByte))
                    {
                        int currentKey = map.get(oneByte);
                        map.put(oneByte, ++currentKey);
                    }
                    else
                    {
                        map.put(oneByte, 1);
                    }
                }
                else
                {
                    int maxByte = 0;
                    int maxKey = 0;
                    for (Map.Entry<Integer, Integer> pair : map.entrySet())
                    {
                        int key = pair.getKey();
                        int value = pair.getValue();

                        if (value > maxByte)
                        {
                            maxByte = value;
                            maxKey = key;
                        }
                    }
                    resultMap.put(fileName, maxKey);
                    in.close();
                    break;
                }
            }
            }
            catch (Exception e) {}
        }
    }
}
