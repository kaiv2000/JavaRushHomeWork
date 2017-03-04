package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    public void execute() throws InterruptOperationException {

        res.getString("before");
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        int sum;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String input = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!manipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            try
            {
                manipulator.withdrawAmount(sum);
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                break;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currency));
            break;
        }
    }
}
