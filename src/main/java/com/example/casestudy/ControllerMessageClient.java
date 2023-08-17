package com.example.casestudy;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class ControllerMessageClient implements Initializable {
    @FXML
    private Button buttonSend;
    @FXML
    private TextField tfMessage;
    @FXML
    private VBox vboxMessage;
    private Client client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            client = new Client(new Socket("localhost",1212));
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.receiveMessageFromServer(vboxMessage);
        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String messageToSend = tfMessage.getText();
                if (!messageToSend.isEmpty()){
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5,5,5,10));

                    Text text = new Text(messageToSend);
                    TextFlow textFlow = new TextFlow(text);
                    textFlow.setPadding(new Insets(5,10,5,10));
                    hBox.getChildren().add(textFlow);

                    vboxMessage.getChildren().add(hBox);

                    client.sendMessageToServer(messageToSend);
                    tfMessage.clear();
                }
            }
        });
    }

    public static void addLabel(String messageFromServer, VBox vBox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));

        Text text = new Text(messageFromServer);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox);
            }
        });
    }
}

