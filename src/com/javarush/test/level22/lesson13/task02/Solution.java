package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        String fileFrom = args[0];
        String fileTo = args[1];

        FileInputStream inputStream = new FileInputStream(fileFrom);
        FileOutputStream outputStream = new FileOutputStream(fileTo);
        byte[] buffer = new byte[1024];
        while (inputStream.available() > 0)
        {
            int count = inputStream.read(buffer);

            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = Charset.forName("UTF-8");
            String s = new String(buffer, utf8);
            buffer = s.getBytes(windows1251);
            outputStream.write(buffer, 0, count);
        }
        inputStream.close();
        outputStream.close();
    }
}
