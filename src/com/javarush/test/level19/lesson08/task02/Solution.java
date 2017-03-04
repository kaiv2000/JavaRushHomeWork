package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out; //запоминаем настоящий PrintStream в специальную переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //Создаем динамический массив
        PrintStream stream = new PrintStream(outputStream); //создаем адаптер к классу PrintStream
        System.setOut(stream);  //Устанавливаем его как текущий System.out

        testString.printSomething(); //Вызываем функцию, которая ничего не знает о наших манипуляциях

        String result = outputStream.toString(); //Преобразовываем записанные в наш ByteArray данные в строку
        System.setOut(consoleStream);  //Возвращаем все как было

        String output = result.replaceAll("te", "??");

        System.out.println(output); //выводим ее в консоль
    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}