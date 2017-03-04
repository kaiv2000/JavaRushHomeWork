package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader fileInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String oneLine = "";
        Person onePerson;

        int stringFormat;
        while ((oneLine = fileInput.readLine()) != null)
        {
            String[] onePersonLine = oneLine.split(" ");
            stringFormat = onePersonLine.length;
            int year = 0;
            int month = 0;
            int day = 0;
            if (stringFormat == 4)
            {
                String surname = onePersonLine[0];
                day = Integer.parseInt(onePersonLine[1]);
                month = Integer.parseInt(onePersonLine[2]);
                year = Integer.parseInt(onePersonLine[3]);
                Date birthday = new GregorianCalendar(year, month-1, day).getTime();
                    onePerson = new Person(surname, birthday);
                    PEOPLE.add(onePerson);
            }

            if (stringFormat == 5)
            {
                String surname = onePersonLine[0];
                String name = onePersonLine[1];
                String fullName = surname + " " + name;
                day = Integer.parseInt(onePersonLine[2]);
                month = Integer.parseInt(onePersonLine[3]);
                year = Integer.parseInt(onePersonLine[4]);
                Date birthday = new GregorianCalendar(year, month-1, day).getTime();
                onePerson = new Person(fullName, birthday);
                PEOPLE.add(onePerson);
            }

            if (stringFormat == 6)
            {
                String surname = onePersonLine[0];
                String name = onePersonLine[1];
                String middleName = onePersonLine[2];
                String fullName = surname + " " + name + " " + middleName;
                day = Integer.parseInt(onePersonLine[3]);
                month = Integer.parseInt(onePersonLine[4]);
                year = Integer.parseInt(onePersonLine[5]);
                Date birthday = new GregorianCalendar(year, month-1, day).getTime();
                onePerson = new Person(fullName, birthday);
                PEOPLE.add(onePerson);
            }

        }
        fileInput.close();
    }
}
