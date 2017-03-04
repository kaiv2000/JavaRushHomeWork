package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");


    public static void writeMessage(String message){

        System.out.println(message);
    }

    private static BufferedReader reader;

    public static String readString() throws InterruptOperationException {
        if (reader == null)
            reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try
        {
            input = reader.readLine();
            if (input.equalsIgnoreCase("exit"))
                throw new InterruptOperationException(res.getString("the.end"));
        }
        catch (IOException e)
        {
        }
        return input;
    }

    public static String askCurrencyCode() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
        String currency = "";
            while (true)
            {
                currency = readString();
                if (currency.length() == 3)
                {
                    break;
                }
                else
                {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                }
            }
        currency = currency.toUpperCase();
        return currency;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        String[] denomAndQuantity;

        while (true)
        {
            String twoDigitsinput = readString();
            denomAndQuantity = twoDigitsinput.split(" ");
            int denomination;
            int quantity;
            try
            {
                denomination = Integer.parseInt(denomAndQuantity[0]);
                quantity = Integer.parseInt(denomAndQuantity[1]);
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (denomination < 0 || quantity < 0 || denomAndQuantity.length != 2)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return denomAndQuantity;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
      while (true)
      {
          ConsoleHelper.writeMessage(res.getString("choose.operation"));

          ConsoleHelper.writeMessage(res.getString("operation.INFO") + " : 1");
          ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT") + " : 2");
          ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW") + " : 3");
          ConsoleHelper.writeMessage(res.getString("operation.EXIT") + " : 4");


          String input = readString();
          if (input.matches("^[0-4]$"))
              return Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
          else
              ConsoleHelper.writeMessage(res.getString("invalid.data"));
      }
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage("Thank you!");
    }

}











