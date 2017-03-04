package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы

        String name;
        int age;
        int height;
        int width;
        int weigth;
        int childrens;

        Human (String name)
        {
            this.name = name;
        }

        Human (String name, int age)
        {
            this.name = name;
            this.age = age;

        }

        Human (String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        Human (String name, int age, int height, int width)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;

        }

        Human (String name, int age, int height, int width, int weigth)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
        }

        Human (String name, int age, int height, int width, int weigth, int childrens)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
            this.childrens = childrens;
        }

        Human (int height, int width, int weigth, int childrens, String name,int age)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
            this.childrens = childrens;
        }

        Human (int width, int weigth, int childrens, String name,int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
            this.childrens = childrens;
        }
        Human (int weigth, int childrens, String name, int age, int height, int width)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
            this.childrens = childrens;
        }

        Human (int age, int height, int width, int weigth, int childrens, String name)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.width = width;
            this.weigth = weigth;
            this.childrens = childrens;
        }

    }
}
