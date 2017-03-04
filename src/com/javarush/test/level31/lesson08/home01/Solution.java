package com.javarush.test.level31.lesson08.home01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* Null Object Pattern
Почитайте на вики про паттерн "Null Object"
Используйте Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируйте поле объектом NullFileData.
*/
public class Solution {

    private FileData fileData;

    public Solution(String pathToFile){

        boolean isHidden = false;
        try
        {
            File file = new File(pathToFile);
            isHidden = Files.isHidden(file.toPath());
            boolean isExecutable = Files.isExecutable(file.toPath());
            boolean isDirectory = Files.isDirectory(file.toPath());
            boolean isWritable = Files.isWritable(file.toPath());
            fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);
        }
        catch (Exception e)
        {
            fileData = new NullFileData(e);
        }


    }

    public FileData getFileData() {
        return fileData;
    }
}
