package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }

        //min sort for x

        for(int i = 0; i <array.length; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if( array[j] > array[j+1] )
                {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        int x = array[0];

        //max sort for y

        for(int i = 0; i <array.length ;i++)
        {
            for(int j = 0; j < array.length;j++)
            {
                if(array[i]>= array[j])
                {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j]= tmp;
                }
            }
        }

        int y = array[0];


        return new Pair<Integer, Integer>(x, y);
    }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
