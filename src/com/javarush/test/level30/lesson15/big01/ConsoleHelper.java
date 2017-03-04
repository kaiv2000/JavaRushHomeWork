package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static int readInt(){
        int inputNumber;
        while (true) {
            try {
                inputNumber = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return inputNumber;
    }

    public static String readString()
    {
        String input = "";
        while (true)
        {
            try
            {
                input = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                readString();
            }
        }
        return input;
    }

}
