package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException{

        Waitor waitor = new Waitor();
        Cook cooker1 = new Cook("SuperCooker-1");
        cooker1.addObserver(waitor);
        Cook cooker2 = new Cook("SuperCooker-2");
        cooker2.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for(int i = 0;i < 5; i++){
            Tablet tablet = new Tablet(i + 1);
            tablets.add(tablet);
        }

        Thread cooker1Thread = new Thread(cooker1);
        cooker1Thread.start();
        Thread cooker2Thread = new Thread(cooker2);
        cooker2Thread.start();

        Thread randomOrderGeneratorTaskThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        randomOrderGeneratorTaskThread.start();
        try
        {
            Thread.sleep(1000);

        }
        catch (InterruptedException e)
        {

        }

        randomOrderGeneratorTaskThread.interrupt();

        while (!queue.isEmpty()){
            Thread.sleep(1);
        }

        while ((cooker1.isBusy())||(cooker2.isBusy())) { Thread.sleep(1);}
        cooker1Thread.interrupt();
        cooker2Thread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}