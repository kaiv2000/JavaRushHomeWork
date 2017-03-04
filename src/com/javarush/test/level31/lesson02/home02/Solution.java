package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        List<String> fileL = getFileTree("d:/soft");
        for (String x : fileL) System.out.println(x);
    }

    static List<String> fileList = new ArrayList<>();

    public static List<String> getFileTree(String root) throws IOException {

        List<String> fileList = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File source = new File(root);
        stack.push(source);
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for (File oneFile : child.listFiles()) {
                    stack.push(oneFile);
                }
            } else if (child.isFile()) {
                fileList.add(child.getAbsolutePath());
            }
        }
        return fileList;


       /* File source = new File(root);
        if (source.isFile())
        {
            fileList.add(source.getAbsolutePath());
        }
        else
        {
            File[] filearray = source.listFiles();
            for (File oneFile : filearray)
            {
                getFileTree(oneFile.getAbsolutePath());
            }
        }
        return fileList;*/
    }
}
