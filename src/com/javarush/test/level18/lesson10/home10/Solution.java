package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        List<byte[]> buffersList = new ArrayList<byte[]>();
        String outFilename = "";

        while(!(fileName = reader.readLine()).equals("end"))
        {
            new MakeBuffer(fileName, buffersList).start();
            int partIndex = fileName.lastIndexOf(".part");
            outFilename = (String) fileName.subSequence(0, partIndex);
        }
        OutputStream outFile = new FileOutputStream(outFilename);
        reader.close();

        for (int i = 0; i <= buffersList.size()-1; i++)
            outFile.write(buffersList.get(i));
        outFile.close();
    }

    public static class MakeBuffer extends Thread
    {
        String fileName;
        List<byte[]> buffersList;
        public MakeBuffer(String filename, List<byte[]> buffersList)
        {
            this.fileName = filename;
            this.buffersList = buffersList;
        }
        String bufferName = fileName;
        InputStream in;

        public void run()
        {
            try
            {
                in = new FileInputStream(fileName);
                byte[] buffer = new byte[in.available()];
                while (in.available() > 0)
                {
                    in.read(buffer);
                    buffersList.add(buffer);
                }
                in.close();
            }
            catch (Exception e){System.out.println("Problem with file read");}
        }
    }
}