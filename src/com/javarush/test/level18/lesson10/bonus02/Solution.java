package com.javarush.test.level18.lesson10.bonus02;

/* ������
CrUD ��� ������� ������ �����
������� � ������� ��� ����� ��� �������� CrUD
��������� ����������� �� ��������� ������� ����������:
-c productName price quantity
�������� ����������:
��� id - 8 ��������
productName - �������� ������, 30 chars (60 bytes)
price - ����, 8 ��������
quantity - ����������, 4 �������
-c  - ��������� ����� � ��������� ����������� � ����� �����, ���������� id ��������������, ������������� ������������ id, ��������� � �����

� ����� ������ �������� � ��������� ������������������ (��� ����������� ��������):
id productName price quantity
������ ��������� ��������� �� �� �����

������:
19846   ����� ������� �����           159.00  12
198478  ����� ������� ������ � �������173.00  17
19847983������ ��� �������������, ����10173.991234
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
