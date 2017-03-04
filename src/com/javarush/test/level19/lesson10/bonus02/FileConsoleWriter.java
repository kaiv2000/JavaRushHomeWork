package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;
import java.util.Arrays;

public class FileConsoleWriter extends FileWriter

{
    public FileConsoleWriter(String fileName) throws IOException {super(fileName);}




    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.print(Arrays.copyOfRange(cbuf, off, off + len));
        super.write(cbuf, off, len);
    }
}
