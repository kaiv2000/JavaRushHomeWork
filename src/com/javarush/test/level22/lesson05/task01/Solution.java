package com.javarush.test.level22.lesson05.task01;


/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - best service study4"));
        getPartOfString(null);
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {

        if (string == null)
            throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if (firstSpace == -1)
            throw new TooShortStringException();
        int lastSpace = string.indexOf(" ", firstSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        String afterLastSpace = string.substring(lastSpace + 1);
        char[] afterLastSpaceArray = afterLastSpace.toCharArray();
        int index = 0;
        if (!Character.isLetter(afterLastSpaceArray[0]))
            throw new TooShortStringException();

        for (int i = 1; i < afterLastSpaceArray.length; i++)
        {
            if (Character.isLetter(afterLastSpaceArray[i]))
                index = i;
            else
                break;
        }

        return string.substring(firstSpace+1, lastSpace + index + 2);
}



    public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
        if (str == null || searchStr == null || ordinal <= 0) {
            return -1;
        }
        if (searchStr.length() == 0) {
            return 0;
        }
        int found = 0;
        int index = -1;
        do {
            index = str.indexOf(searchStr, index + 1);
            if (index < 0) {
                return index;
            }
            found++;
        }
        while (found < ordinal);
        return index;
    }


    public static class TooShortStringException extends Exception {

    }
}
