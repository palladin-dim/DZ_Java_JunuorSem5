package com.example.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager {

    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try
        {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     name = bufferedReader.readLine();
     clients.add(this);
     System.out.println(name + " Подключился к чату! ");
    }
        catch (IOException e) {
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " Покинул чат.");
    }
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
     removeClient();

     try {
     if (bufferedReader != null) {
         bufferedReader.close();
     }
     if (bufferedWriter != null) {
         bufferedWriter.close();
     }
     if (socket != null) {
         socket.close();
     }
    }
     catch (IOException e) {
         e.printStackTrace();
     }
    }


}