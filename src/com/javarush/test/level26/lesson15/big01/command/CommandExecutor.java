package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static Map<Operation, Command> operations = new HashMap<>();
    static
    {
        operations.put(Operation.DEPOSIT, new DepositCommand());
        operations.put(Operation.EXIT, new ExitCommand());
        operations.put(Operation.INFO, new InfoCommand());
        operations.put(Operation.WITHDRAW, new WithdrawCommand());
        operations.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        operations.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
