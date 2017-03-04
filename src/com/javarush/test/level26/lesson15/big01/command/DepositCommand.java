package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currCode =  ConsoleHelper.askCurrencyCode();
        String[] denomAndQuant = ConsoleHelper.getValidTwoDigits(currCode);
        try
        {
            int k = Integer.parseInt(denomAndQuant[0]);
            int l = Integer.parseInt(denomAndQuant[1]);
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode).addAmount(Integer.parseInt(denomAndQuant[0]), Integer.parseInt(denomAndQuant[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k*l, currCode));
        }
        catch (NumberFormatException  e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
