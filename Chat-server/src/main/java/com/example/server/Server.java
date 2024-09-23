package com.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        while (serverSocket.isClosed()) {

            try {
            Socket socket = serverSocket.accept();
            System.out.println("Подключён новый клиент!");
            ClientManager clientManager = new ClientManager(socket);

        }
            catch (IOException ignored) {

            }
        }
    }


    private void closeSocket()
    {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }