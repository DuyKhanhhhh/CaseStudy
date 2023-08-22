package com.example.casechat;

import javafx.scene.control.Label;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void SendMessageToServer(String message) {
        try {
            ImportToDataBase importToDataBase = new ImportToDataBase();
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromServer (Label label){
        new Thread(() -> {
            while (socket.isConnected())
                try {
                    String messageByte = bufferedReader.readLine();
                    label.setText(messageByte);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
        });
    }
}
