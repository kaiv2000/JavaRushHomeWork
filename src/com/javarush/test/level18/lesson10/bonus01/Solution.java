package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if(args.length < 2) return;

        InputStream in = new FileInputStream(args[1]);;
        OutputStream out = new FileOutputStream(args[2]);

        if (args[0].equals("-e")) encrypt(in, out);
        if (args[0].equals("-d")) decrypt(in, out);

        in.close();
        out.close();
    }

    public static void encrypt(InputStream in, OutputStream out) throws IOException
    {
        while (true)
        {
            int oneByte = in.read();
            if (oneByte != -1)
            {out.write(oneByte+1);}
            else break;
        }
    }

    public static void decrypt(InputStream in, OutputStream out) throws IOException
    {
        while (true)
        {
            int oneByte = in.read();
            if (oneByte != -1)
            {out.write(oneByte-1);}
            else break;
        }
    }
}
