package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два
объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String catgrandFName = reader.readLine();
        Cat catgrandF = new Cat(catgrandFName, null, null);

        String catgrandMName = reader.readLine();
        Cat catgrandM = new Cat(catgrandMName, null, null);

        String catfatherName = reader.readLine();
        Cat catfather = new Cat(catfatherName, null, catgrandF);

        String catmotherName = reader.readLine();
        Cat catMother = new Cat(catmotherName, catgrandM, null);

        String catsonName = reader.readLine();
        Cat catson = new Cat(catsonName, catMother, catfather);

        String catDaughterName = reader.readLine();
        Cat catDaughter = new Cat(catDaughterName, catMother, catfather);

        System.out.println(catgrandF);
        System.out.println(catgrandM);
        System.out.println(catfather);
        System.out.println(catMother);
        System.out.println(catson);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat catMother;
        private Cat catfather;


        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat catfather, Cat catMother)
        {
            this.name = name;
            this.catMother = catMother;
            this.catfather = catfather;
        }

        @Override
        public String toString()
        {
            if (catMother== null &&  catfather== null)
                return "Cat name is " + name + ", no mother, no father";
            if (catMother == null)
                return "Cat name is " + name + ", no mother, father is " + catfather.name;
            if (catfather == null)
                return "Cat name is " + name + ", mother is " + catMother.name + ", no father";
                else
                return "Cat name is " + name + ", mother is " + catMother.name + ", father is " + catfather.name;
        }
    }
}