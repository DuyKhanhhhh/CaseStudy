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

public class ClientController {
    @FXML
    private Label label;
    @FXML
    private TextField tfMessage;

    @FXML
    public void buttonSend(ActionEvent event) {
        try {
            ClientController clientController = new ClientController();
            Socket socket = clientController.socket();
            ImportToDataBase importToDataBase = new ImportToDataBase();
            String message = tfMessage.getText();
            String Message = SendMessageToServer(socket, message);
            importToDataBase.addDatabase("Client", Message);
            if (message.equalsIgnoreCase("exit")) {
                importToDataBase.deleteData();
            }
            ReadFromServer(socket);
            StringBuilder listMessage = importToDataBase.ReadMessageToDatabase();
            this.label.setText(String.valueOf(listMessage));
            tfMessage.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket socket() throws IOException {
        String address = "localhost";
        int port = 8080;
        Socket socket = new Socket(address, port);
        System.out.println("Connected to server");
        return socket;
    }

    public static String SendMessageToServer(Socket socket, String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        String driverMessage = message;
        outputStream.write(driverMessage.getBytes());
        outputStream.flush();
        return driverMessage;
    }

    public static String ReadFromServer(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] list = new byte[1024];
        int read = inputStream.read(list);
        String message = new String(list, 0, read);
        return message;
    }
}

