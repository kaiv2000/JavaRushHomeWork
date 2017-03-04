package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private Tablet tablet;
    protected List<Dish> dishes;
    private int cookingTime;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString()
    {
        if (dishes == null || dishes.isEmpty())
        return "";
        else
            return "Your order: " + dishes.toString() + " of " + tablet;
    }


    public int getTotalCookingTime(){

        int totalTime = 0;

        for (Dish x : dishes)
        {
            totalTime = totalTime + x.getDuration();
        }
        return totalTime;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


}
