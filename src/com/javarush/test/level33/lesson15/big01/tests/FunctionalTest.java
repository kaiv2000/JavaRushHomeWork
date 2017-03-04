package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest { //проверим функциональность наших стратегий

    public void testStorage(Shortener shortener){
        String testString1 = Helper.generateRandomString();
        String testString2 = Helper.generateRandomString();
        String testString3 = testString1;

        Long testId = shortener.getId(testString1);
        Long testId2 = shortener.getId(testString2);
        Long testId3 = shortener.getId(testString3);

        Assert.assertNotEquals(testId2, testId);
        Assert.assertNotEquals(testId2, testId3);

        Assert.assertEquals(testId, testId3);

        String gettedString = shortener.getString(testId);
        String gettedString2 = shortener.getString(testId2);
        String gettedString3 = shortener.getString(testId3);

        Assert.assertEquals(testString1, gettedString);
        Assert.assertEquals(testString2, gettedString2);
        Assert.assertEquals(testString3, gettedString3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }

}
