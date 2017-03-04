package com.javarush.test.level22.lesson13.task01;

import java.util.*;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args)
    {
        String[] s = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(s));
    }

    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens()){
         String token = tokenizer.nextToken();
            list.add(token);
        }
        String[] s = new String[list.size()];
        s = list.toArray(s);
        return s;
    }
}