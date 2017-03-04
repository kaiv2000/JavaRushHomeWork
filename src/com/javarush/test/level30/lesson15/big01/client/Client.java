package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();

            } catch (InterruptedException e) {
                System.out.println("Client socket error =(");
                return;
            }
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Connection established. Type 'exit' to shutdown program.");
        } else {
            ConsoleHelper.writeMessage("Clinet connection error.");
        }

        while (clientConnected) {
            String textFromClient = ConsoleHelper.readString();
            if (textFromClient.equalsIgnoreCase("exit"))
                break;
            if (shouldSentTextFromConsole())
                sendTextMessage(textFromClient);
        }

    }


    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " was added to chat. Congratulations!");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " leave chat. Unfortunatelly...");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }


        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case NAME_REQUEST:
                        String clientName = getUserName();
                        Message messageWithUserName = new Message(MessageType.USER_NAME, clientName);
                        connection.send(messageWithUserName);
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run(){
            String serverAddress =  getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket clientSocket = new Socket(serverAddress, serverPort);
                Client.this.connection = new Connection(clientSocket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }

        }

    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter server address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter username or nick name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {

        Message message = new Message(MessageType.TEXT, text);
        try {
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("problem with message sending");
            clientConnected = false;
        }

    }

}
