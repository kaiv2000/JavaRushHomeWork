package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

public enum  Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    public static String allDishesToString()
    {
        StringBuilder sb = new StringBuilder(Arrays.toString(values()));
        sb.delete(sb.length() - 1, sb.length());
        sb.delete(0, 1);
        return sb.toString();
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }
}
