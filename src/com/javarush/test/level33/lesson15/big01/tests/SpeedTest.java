package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {

        Date startDate = new Date();

        for (String oneString : strings) {
            ids.add(shortener.getId(oneString));
        }

        Date endDate = new Date();
        return endDate.getTime() - startDate.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {

        Date startDate = new Date();

        for (Long oneId : ids) {
            strings.add(shortener.getString(oneId));
        }

        Date endDate = new Date();
        return endDate.getTime() - startDate.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        long timeHashMap = getTimeForGettingIds(shortener1, origStrings, ids1);
        long timeHashBiMap = getTimeForGettingIds(shortener2, origStrings, ids2);

        Assert.assertTrue(timeHashMap > timeHashBiMap);

        long timeHashMapString = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        long timeHashBiMapString = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());

        Assert.assertEquals(timeHashMapString, timeHashBiMapString, 5);
    }


}
