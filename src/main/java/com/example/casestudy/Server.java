package com.example.casestudy;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) {
    try {
     this.serverSocket = serverSocket;
     this.socket = serverSocket.accept();
     this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }catch (IOException e){
        e.printStackTrace();
    }
    }

    public void sendMessageToClient(String messageToClient){
        try {
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            ImportDatabase importDatabase = new ImportDatabase();
            importDatabase.addToDatabase("Server", messageToClient);
            importDatabase.getData();
            if (messageToClient.equalsIgnoreCase("exit")){
                importDatabase.deleteData();
            }
        } catch (IOException e) {
            e.printStackTrace();
            closeEvyThing(socket,bufferedReader,bufferedWriter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageFromClient(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String messageFromClient = bufferedReader.readLine();
                        ControllerMessageServer.addLabel(messageFromClient, vBox);

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
