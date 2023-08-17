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
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMessageServer implements Initializable {
    @FXML
    private Button buttonSend;
    @FXML
    private TextField tfMessage;
    @FXML
    private VBox vboxMessage;

    private Server server;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            server = new Server(new ServerSocket(1212));
            System.out.println("Server Open");
        }catch (IOException e){
            e.printStackTrace();
        }

        server.receiveMessageFromClient(vboxMessage);

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

                    server.sendMessageToClient(messageToSend);
                    tfMessage.clear();
                }
            }
        });
    }
public static void addLabel(String messageFromClient, VBox vBox){
    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER_LEFT);
    hBox.setPadding(new Insets(5,5,5,10));

    Text text = new Text(messageFromClient);
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
