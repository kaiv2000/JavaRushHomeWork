package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String Inputnumber1 = "";
        String Inputnumber2 = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Inputnumber1 = reader.readLine();
        Inputnumber2 = reader.readLine();

        int num1 = Integer.parseInt(Inputnumber1);
        int num2 = Integer.parseInt(Inputnumber2);

        System.out.println(gcd(num1, num2));
    }

    public static int gcd(int num1, int num2)
    {
        if (num2 == 0) return num1;
        int x = num1 % num2;
        return gcd(num2, x);
    }
}
