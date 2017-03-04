package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    private static int botCounter = 0;

    public static void main(String[] args) {
        new BotClient().run();
    }


    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText = message.split(": ");
            if (nameAndText.length == 2) {
                String messageAuthor = nameAndText[0];
                String messageText = nameAndText[1];
                String dateFormat = null;
                switch (messageText) {
                    case "дата":
                        dateFormat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateFormat = "d";
                        break;
                    case "месяц":
                        dateFormat = "MMMM";
                        break;
                    case "год":
                        dateFormat = "YYYY";
                        break;
                    case "время":
                        dateFormat = "H:mm:ss";
                        break;
                    case "час":
                        dateFormat = "H";
                        break;
                    case "минуты":
                        dateFormat = "m";
                        break;
                    case "секунды":
                        dateFormat = "s";
                        break;
                }
                if (dateFormat != null)
                {
                    String sendDate = new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
                    String botMessage = String.format("Информация для %s: %s", messageAuthor, sendDate);
                    sendTextMessage(botMessage);
                }

            }

        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        if (botCounter == 99) botCounter = 0;
        return "date-bot-" + botCounter++;
    }
}
