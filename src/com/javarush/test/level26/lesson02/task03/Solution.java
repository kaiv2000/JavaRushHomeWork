package com.javarush.test.level26.lesson02.task03;

import java.util.Comparator;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {

        public CustomizedComparator(Comparator<T>... comparators)
        {
            this.comparators = comparators;
        }

        private Comparator<T>[] comparators;

        public int compare(T o, T t1) {
            int difference = 0;
            for (Comparator<T> comparator : comparators)
            {
                difference = comparator.compare(o, t1);
                if (difference != 0)
                    break;
            }
            return difference;
        }
    }

}
