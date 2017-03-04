package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;

public class Entry<key, value> implements Serializable {

    final Long key;
    String value;
    Entry<key, value> next;
    final int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public int hashCode(){
        return  (getKey()==null   ? 0 : getKey().hashCode()) ^ (getValue()==null ? 0 : getValue().hashCode());
    }

    public String toString(){
        return key + "=" + value;
    }

}
