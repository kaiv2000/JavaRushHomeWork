package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>(); // ключом будет имя клиента, а значением - соединение с ним

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Enter server port please: ");
        int serverPort = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            ConsoleHelper.writeMessage("Server started =)");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Handler handler = new Handler(clientSocket);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println("Server socket creation error =(");
        } finally {
            serverSocket.close();
        }

    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                pair.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Some error. Message was not sended =(");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        public void run() {

            ConsoleHelper.writeMessage(String.format("New Connection established with: %s", socket.getRemoteSocketAddress()));
            String newClintName = null;
            try (Connection connection = new Connection(socket)) {
                newClintName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClintName));
                sendListOfUsers(connection, newClintName);
                serverMainLoop(connection, newClintName);

            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Data exchange error with remote address: %s", socket.getRemoteSocketAddress()));
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(String.format("Data exchange error with remote address: %s", socket.getRemoteSocketAddress()));
            }

            if (newClintName != null)
            {
                connectionMap.remove(newClintName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClintName));
            }
            ConsoleHelper.writeMessage(String.format("Connection &s closed.", socket.getRemoteSocketAddress()));

        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            boolean accepted = false;
            String userName = "";
            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message messageFromClient = connection.receive();
                userName = messageFromClient.getData();
                if (messageFromClient.getType() == MessageType.USER_NAME) {
                    if (messageFromClient.getData() != null && !(userName.isEmpty())) {
                        if (!connectionMap.containsKey(userName)) {
                            connectionMap.put(userName, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            accepted = true;
                        }
                    }
                }
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String currentClinentName : connectionMap.keySet()) {
                Message messageWithAllClients = new Message(MessageType.USER_ADDED, currentClinentName);
                if (!currentClinentName.equals(userName))
                    connection.send(messageWithAllClients);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String newTextMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, newTextMessage));
                } else {
                    ConsoleHelper.writeMessage(String.format("Bad input text(MessageType.%s) from client %s", message.getType().toString(), userName));
                }
            }
        }
    }
}
