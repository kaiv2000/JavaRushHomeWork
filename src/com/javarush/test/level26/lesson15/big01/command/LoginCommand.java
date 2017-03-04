package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));

        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            if (!cardNumber.matches("^[0-9]{12}$") || !pinCode.matches("^[0-9]{4}$"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.containsKey(cardNumber))
            {
                if (validCreditCards.getString(cardNumber).equals(pinCode))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
                break;
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
