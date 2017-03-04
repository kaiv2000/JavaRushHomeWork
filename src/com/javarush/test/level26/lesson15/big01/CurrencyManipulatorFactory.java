package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

public final class CurrencyManipulatorFactory {

     static HashMap<String, CurrencyManipulator> manipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        CurrencyManipulator manipulator;

        if (manipulators.containsKey(currencyCode))
        {
            return manipulators.get(currencyCode);
        }
        else
        {
            manipulator = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, manipulator);
            return manipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }


    private CurrencyManipulatorFactory() {}
}