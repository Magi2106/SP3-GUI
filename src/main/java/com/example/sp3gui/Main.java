package com.example.sp3gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static java.lang.System.exit;




public class Main extends Application {
    MainController main = new MainController();


    public static void main(String[] args) {
        launch(args);

    }
// 1. LAV SAVED MEDIA LISTE SÅ MAN KAN SE DEN / DEN OPDATERE SIG SELV.
// 2. GUstav CLEANER LORTET UP SÅ DET SER BANGER UD OG LIGNER PORNHUB!
// 3. Save metoder til user watched/saved media.

    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file for the login screen
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        // Create the root node as Pane by loading the FXML
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 800); // Adjust the size to match the FXML's prefHeight and prefWidth
        primaryStage.setTitle("ShrekFlix.exe");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}









