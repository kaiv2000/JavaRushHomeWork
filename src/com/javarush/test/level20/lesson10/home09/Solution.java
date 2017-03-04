package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable
{
    int node;
    List<Solution> edges = new LinkedList<Solution>();

    Solution(){}

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        FileOutputStream fileOutput = new FileOutputStream("cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(solution);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream("cat.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        Solution newCat = (Solution)object;

    }

}
