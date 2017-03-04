package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable
{
    public static void main(String[] args) throws Exception
    {
        Solution mySolution = new Solution("d:/0.txt");
        mySolution.writeObject("testik");
        mySolution.close();

        FileOutputStream fileOut = new FileOutputStream("d:/1.txt");
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(mySolution);
        outStream.close();

        FileInputStream fis = new FileInputStream("d:/1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object loadedObject = ois.readObject();
        ois.close();

        Solution newSolution = (Solution) loadedObject;

        newSolution.writeObject("testik2");
        newSolution.close();

    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException
    {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
    }

    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
