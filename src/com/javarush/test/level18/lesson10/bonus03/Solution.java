package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        int id = Integer.parseInt(args[1]);

        if (args[0].equals("-u"))
        {
            String productName = args[2];
            double price = Double.parseDouble(args[3]);
            int quantity = Integer.parseInt(args[4]);
            updateGoods(id, productName, price, quantity, fileName);
        }
        if (args[0].equals("-d")) deleteGoods(id, fileName);

        else return;
    }

    public static void updateGoods(int id, String productName, double price, int quantity, String fileName) throws IOException
    {
        ArrayList<String> allGoodsArray = new ArrayList<String>();
        int searchId = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = "";
        while( (line = in.readLine()) != null)
        {
            allGoodsArray.add(line + "\r\n");
        }

        String addId = String.format("%-8s", id);
        String addproductName = String.format("%-30s", productName);
        String addprice = String.format("%-8s", price);
        String addQuantity = String.format("%-4s%n", quantity);
        String lineForAdding = addId + addproductName + addprice + addQuantity;

        for (int i = 1; i < allGoodsArray.size()-1; i++)
        {
            searchId = Integer.parseInt(allGoodsArray.get(i).substring(0, 8).trim());
            if (searchId == id)
            {
                allGoodsArray.set(i,lineForAdding);
                break;
            }
        }

        OutputStream out = new FileOutputStream(fileName);

        for (String oneLine : allGoodsArray)
        {
            out.write(oneLine.getBytes());
        }
        in.close();
        out.close();
    }

    public static void deleteGoods(int id, String fileName) throws IOException
    {
        ArrayList<String> allGoodsArray = new ArrayList<String>();
        int searchId = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = "";
        while( (line = in.readLine()) != null)
        {
            allGoodsArray.add(line + "\r\n");
        }

        for (int i = 1; i < allGoodsArray.size()-1; i++)
        {
            searchId = Integer.parseInt(allGoodsArray.get(i).substring(0, 8).trim());
            if (searchId == id)
            {
                allGoodsArray.remove(i);
                break;
            }
        }

        OutputStream out = new FileOutputStream(fileName);

        for (String oneLine : allGoodsArray)
        {
            out.write(oneLine.getBytes());
        }
        in.close();
        out.close();
    }
}
