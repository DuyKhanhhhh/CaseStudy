package com.example.casestudy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMessageServer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMessageServer.class.getResource("DisplayMessageServer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 500.0);
        primaryStage.setTitle("Message Server!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
