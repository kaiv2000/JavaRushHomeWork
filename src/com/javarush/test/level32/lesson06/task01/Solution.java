package com.javarush.test.level32.lesson06.task01;

import java.io.*;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        StringBuilder tmp = new StringBuilder();
        char[] symbolsLitte;
        char[] symbolsCap;
        char[] symbolsDigits;

        for (char ch = 'a'; ch <= 'z'; ++ch)
            tmp.append(ch);
        symbolsLitte = tmp.toString().toCharArray();
        tmp.delete(0, tmp.length());


        for (char ch = 'A'; ch <= 'Z'; ++ch)
            tmp.append(ch);
        symbolsCap = tmp.toString().toCharArray();
        tmp.delete(0, tmp.length());

        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
        symbolsDigits = tmp.toString().toCharArray();
        tmp.delete(0, tmp.length());

        Random random = new Random();
        char[] buf = new char[8];

        for (int i = 0; i < 1; i++) {
            buf[i] = symbolsCap[random.nextInt(symbolsCap.length)];
        }


        for (int i = 1; i < 7; i++) {
            buf[i] = symbolsLitte[random.nextInt(symbolsLitte.length)];
        }


        for (int i = 7; i < 8; i++) {
            buf[i] = symbolsDigits[random.nextInt(symbolsDigits.length)];
        }

        String generatedPass = new String(buf);

        InputStream inputStream = new ByteArrayInputStream(generatedPass.getBytes());
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            while (bis.available() > 0) {
                int data = bis.read();
                outputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return outputStream;
    }
}
