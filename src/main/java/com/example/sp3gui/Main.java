package com.example.sp3gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 726, 546);
        primaryStage.setTitle("ShrekFlix.exe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}









