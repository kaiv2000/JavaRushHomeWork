package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String workString = "";
        String onestring;

        while ((onestring = reader.readLine()) != null) {
            workString += onestring;
        }
        reader.close();
        workString = workString.replaceAll("[^a-zA-Z]", "");

        char[] letters = workString.toCharArray();

        Set<String> lettersSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < letters.length; i++) {
            lettersSet.add(Character.toString(letters[i]).toLowerCase());
        }

        int counter = 1;
        for (String oneChar : lettersSet) {
            if (counter > 5) break;
            System.out.print(oneChar);
            counter++;
        }

    }
}
