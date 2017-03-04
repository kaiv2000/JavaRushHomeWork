package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigDecimal;

public class Solution
{
    public Solution(byte a)
    {
    }

    public Solution(short a)
    {
    }

    public Solution(int a)
    {
    }

    private Solution(long a)
    {
    }

    private Solution(float a)
    {
    }

    private Solution(double a)
    {
    }

    protected Solution(boolean a)
    {
    }

    protected Solution(char a)
    {
    }

    protected Solution(Object a)
    {
    }

    Solution(BigDecimal a)
    {
    }

    Solution(Number a)
    {
    }

    Solution(Exception a)
    {
    }
}