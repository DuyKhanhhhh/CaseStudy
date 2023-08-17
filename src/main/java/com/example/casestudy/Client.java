package com.example.casestudy;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Client(Socket socket){
    try {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    } catch (IOException e) {
        e.printStackTrace();
        closeEvyThing(socket, bufferedReader,bufferedWriter);
    }
}
    public void sendMessageToServer(String messageToServer){
        try {
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            ImportDatabase importDatabase = new ImportDatabase();
            importDatabase.addToDatabase("Client",messageToServer);
            importDatabase.getData();
            if (messageToServer.equalsIgnoreCase("exit")){
                importDatabase.deleteData();
            }
        } catch (IOException e) {
            e.printStackTrace();
            closeEvyThing(socket,bufferedReader,bufferedWriter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageFromServer(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String messageFromServer = bufferedReader.readLine();
                        ControllerMessageServer.addLabel(messageFromServer, vBox);
                    } catch (IOException e) {
                        e.printStackTrace();
                        closeEvyThing(socket,bufferedReader,bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }
    public void closeEvyThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
