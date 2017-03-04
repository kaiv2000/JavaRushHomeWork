package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution extends Thread
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    public static void main(String[] args)
    {
        Thread thread4 = threads.get(3);
        Message message = (Message) thread4;
        thread4.start();
        sleep();
        message.showWarning();
        System.out.println(thread4.isAlive());
    }

    private static void sleep()
    {try
    {
        Thread.sleep(100);
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
    }

    static
    {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static class MyThread1 extends Thread
    {
        public void run()
        {
            while (true){}
        }
    }

    public static class MyThread2 extends Thread
    {
        public void run()
        {

            try
            {
                while (!isInterrupted())
                {

                }
                throw new InterruptedException();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");;
            }
        }
    }

    public static class MyThread3 extends Thread
    {
        public void run()
        {
            while (true)
            {
                try
                {
                    System.out.println("Ура");
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message
    {
        Thread current = Thread.currentThread();

        public void showWarning()
        {
            this.interrupt();
            try
            {
            this.join();
            }
            catch (Exception e){}
        }

        public void run()
        {
            while(!current.interrupted())
            {}
        }


    }

    public static class MyThread5 extends Thread
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum;
        public void run()
        {
            try
            {

                while (!isInterrupted())
                {
                    String s = reader.readLine();
                    if (s.equals("N")) this.interrupt();
                    else sum = sum + Integer.parseInt(s);
                }

            throw new InterruptedException();
        }

            catch (IOException e) {}
            catch (InterruptedException e)
            {
                System.out.println(sum);
            }

        }
    }
}

