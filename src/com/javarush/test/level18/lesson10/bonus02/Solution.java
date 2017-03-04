package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = args[1];
        double price = Double.parseDouble(args[2]);
        int quantity = Integer.parseInt(args[3]);
        if (args[0].equals("-c")) addGoods(productName, price, quantity, fileName);
        else return;
    }

    public static void addGoods(String productName, double price, int quantity, String fileName) throws IOException
    {
        int id = 0;
        int maxid = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = "";
        in.readLine();
        while( (line = in.readLine()) != null)
        {
            id = Integer.parseInt(line.substring(0, 8).trim());
            if (id > maxid) maxid = id;
        }
        in.close();
        maxid++;

        String addMaxId = String.format("%-8s", maxid);
        String addproductName = String.format("%-30s", productName);
        String addprice = String.format("%-8s", price);
        String addQuantity = String.format("%-4s%n", quantity);
        String lineForAdding = addMaxId + addproductName + addprice + addQuantity;

        OutputStream out = new FileOutputStream(fileName, true);
        out.write(lineForAdding.getBytes());
        out.close();
    }
}
