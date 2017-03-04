package com.javarush.test.level05.lesson12.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("man1name", 25, "home1");
        Man man2 = new Man("man1name", 24, "home2");
        Woman woman1 = new Woman("woman1name", 23, "home3");
        Woman woman2 = new Woman("woman1name", 22, "home4");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man
    {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.address=address;
            this.age=age;
        }

        public String toString(){
            return name + " " + age + " " + address;
        }

    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman (String name, int age, String address){
            this.name = name;
            this.address=address;
            this.age=age;
        }

        public String toString(){
            return name + " " + age + " " + address;
        }
    }
}

