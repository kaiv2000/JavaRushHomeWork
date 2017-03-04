package com.javarush.test.level14.lesson06.home01;


public class BelarusianHen extends Hen implements Country
{
     public int getCountOfEggsPerMonth()
    {
        return 25;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}