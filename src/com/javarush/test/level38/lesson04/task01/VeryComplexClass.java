package com.javarush.test.level38.lesson04.task01;

/* Проверяемые исключения (checked exception)
Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.
*/

import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileInputStream fis = null;

        fis = new FileInputStream("B:/myfile.txt");
        int k;
        while(( k = fis.read() ) != -1)
        {
            System.out.print((char)k);
        }
        fis.close();
    }
}
