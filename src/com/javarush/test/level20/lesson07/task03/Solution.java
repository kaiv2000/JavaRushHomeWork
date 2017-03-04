package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Person person = new Person("Name", "Lastname", 25);
        Person mom = new Person("M", "Mom", 45);
        Person dad = new Person("D", "Dad", 48);
        Person son = new Person("Son", "Sonov", 6);
        Person dot = new Person("Dot", "Dotova", 4);
        List<Person> children = new ArrayList<Person>();
        children.add(son);
        children.add(dot);

        person.setMother(mom);
        person.setFather(dad);
        person.setChildren(children);

            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("d:/file.tmp"));
            output.writeObject(person);
            output.close();

            ObjectInputStream input = new ObjectInputStream(new FileInputStream("d:/file.tmp"));
            Person loadPerson = (Person)input.readObject();
            input.close();

            if (person.firstName.equals(loadPerson.firstName) && person.lastName.equals(loadPerson.lastName) && person.age == loadPerson.age)
                System.out.println("true");

    }

    public static class Person implements Externalizable
    {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person(){}


        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }


        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }
}
