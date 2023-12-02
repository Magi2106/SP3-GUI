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
        // Create the root node as Pane by loading the FXML
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 800); // Adjust the size to match the FXML's prefHeight and prefWidth
        primaryStage.setTitle("ShrekFlix.exe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}









