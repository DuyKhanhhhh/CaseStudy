package com.example.casechat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class ServerController implements Initializable{
    @FXML
    private TextArea label;
    @FXML
    private TextField tfMessage;
    @FXML
    private Button buttonSend;
    private Server server;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            server = new Server(new ServerSocket(8080));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        String textMessage = tfMessage.getText();
                        server.SendMessageToClient(textMessage);
                        ImportToDataBase importToDataBase = new ImportToDataBase();
                        importToDataBase.addDatabase("Server", textMessage);
                        StringBuilder listMessage = importToDataBase.ReadMessageToDatabase();
                        server.readFromClient(label);
                        label.setText(String.valueOf(listMessage));
                        tfMessage.clear();
                    }catch (IOException e){
                        System.out.println(e);
                    }catch (SQLException e){
                        System.out.println(e);
                    }
                }
            });
    }
    @FXML
    public void delete(ActionEvent event) {
        try {
            ImportToDataBase importToDataBase = new ImportToDataBase();
            importToDataBase.deleteData();
            label.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}