package com.example.casechat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ServerController{
    @FXML
    private Label label;
    @FXML
    private TextField tfMessage;
    @FXML
    public void buttonSend(ActionEvent event) throws IOException, SQLException {
            ServerController serverController = new ServerController();
            Socket socket = serverController.socket();
            ImportToDataBase importToDataBase = new ImportToDataBase();
            String textMessage = tfMessage.getText();
            SendMessageToClient(socket,textMessage);
            importToDataBase.addDatabase("Server", textMessage);
            if (textMessage.equalsIgnoreCase("exit")){
                importToDataBase.deleteData();
            }
            ReadFromClient(socket);
            StringBuilder listMessage = importToDataBase.ReadMessageToDatabase();
            label.setText(String.valueOf(listMessage));
            tfMessage.setText("");

    }
    public Socket socket() throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Server Open");
        return socket;
    }

    public static String SendMessageToClient(Socket socket, String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        String byteMessage = message;
        outputStream.write(byteMessage.getBytes());
        outputStream.flush();
        return byteMessage;
    }

    public static String  ReadFromClient(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] list = new byte[1024];
        int read = inputStream.read(list);
        String message = new String(list, 0, read);
        return message;
    }

}