package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {

    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    @Override
    public Object clone() {

        AmigoSet<E> amigoSet = new AmigoSet<>();
        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        } catch (Exception e) {
            throw new InternalError();
        }

        return amigoSet;
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, collection.size() / .75f);
        map = new HashMap<E, Object>(capacity);
        this.addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        map.put(e, PRESENT);
        return map.containsKey(e);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();

        out.writeObject(map.size());
        for (E oneElement : map.keySet())
            out.writeObject(oneElement);

        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        int size = (int) in.readObject();
        Set<E> set = new HashSet<E>();
        for (int i = 0; i < size; i++)
        {
            set.add((E) in.readObject());
        }

        int capacity = (int) in.readObject();
        float loadFactor = (float) in.readObject();
        map = new HashMap<E, Object>(capacity, loadFactor);
        for (E oneElement : set)
            map.put(oneElement, PRESENT);

    }

}
