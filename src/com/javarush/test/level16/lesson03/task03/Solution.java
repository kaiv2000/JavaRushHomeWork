package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args)
    {
        //Add your code here - добавьте свой код тут

        SpecialThread printer = new SpecialThread();
        Thread childThread = new Thread(printer);

        SpecialThread printer2 = new SpecialThread();
        Thread childThread2 = new Thread(printer2);

        SpecialThread printer3 = new SpecialThread();
        Thread childThread3 = new Thread(printer3);

        SpecialThread printer4 = new SpecialThread();
        Thread childThread4 = new Thread(printer4);

        SpecialThread printer5 = new SpecialThread();
        Thread childThread5 = new Thread(printer5);


        list.add(childThread);
        list.add(childThread2);
        list.add(childThread3);
        list.add(childThread4);
        list.add(childThread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
