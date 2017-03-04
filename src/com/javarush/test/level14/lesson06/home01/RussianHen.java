package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 27;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
