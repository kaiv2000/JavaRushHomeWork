package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap();

    public V getByKey(K key, Class<V> clazz) throws Exception {

        if (!cache.containsKey(key)) {
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Method testMethod = obj.getClass().getDeclaredMethod("getKey");
            testMethod.setAccessible(true);

            cache.put((K) testMethod.invoke(obj), obj);
            return cache.containsKey(testMethod.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
