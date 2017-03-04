package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().testStrategy(new HashMapStorageStrategy(), 1000);
        new Solution().testStrategy(new OurHashMapStorageStrategy(), 1000);
        new Solution().testStrategy(new FileStorageStrategy(), 10);
        new Solution().testStrategy(new OurHashBiMapStorageStrategy(), 1000);
        new Solution().testStrategy(new HashBiMapStorageStrategy(), 1000);
        new Solution().testStrategy(new DualHashBidiMapStorageStrategy(), 1000);
    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> idents = new HashSet<>();
        for (String element : strings) {
            idents.add(shortener.getId(element));
        }
        return idents;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringsSet = new HashSet<>();
        for (Long element : keys) {
            stringsSet.add(shortener.getString(element));
        }
        return stringsSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSet = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long timeStartGetIds = new Date().getTime();
        Set<Long> keySet = getIds(shortener, testSet);
        Long timeFinishGetIds = new Date().getTime();
        Long durationGetIds = timeFinishGetIds - timeStartGetIds;
        Helper.printMessage(durationGetIds.toString());

        Long timeStartgetStrings = new Date().getTime();
        Set<String> valuesSet = getStrings(shortener, keySet);
        Long timeFinishgetStrings = new Date().getTime();
        Long durationGetStrings = timeFinishgetStrings - timeStartgetStrings;
        Helper.printMessage(durationGetStrings.toString());

        if(testSet.equals(valuesSet))
        {
            Helper.printMessage("Тест пройден.");
        }
        else
        {
            Helper.printMessage("Тест не пройден.");
        }

    }

}
