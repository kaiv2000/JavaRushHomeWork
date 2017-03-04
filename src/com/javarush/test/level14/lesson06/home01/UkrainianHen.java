package com.javarush.test.level14.lesson06.home01;


public class UkrainianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 30;
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
