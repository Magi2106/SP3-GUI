package com.example.sp3gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MainApp extends Application {

    private FileIO io;
    private TextUI ui;
    private Chill ch;
    private User currentUser;
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        // Initialize your existing classes
        io = new FileIO();
        ui = new TextUI();
        try {
            ch = new Chill();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Setup JavaFX components
        VBox root = new VBox(10);
        outputArea = new TextArea();
        Button loadMoviesButton = new Button("Load Movies");

        // Event Handling
        loadMoviesButton.setOnAction(e -> loadMovies());

        root.getChildren().addAll(outputArea, loadMoviesButton);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Media Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadMovies() {
        List<Media> movies = io.loadMovies();
        // Update the UI with movie information
        for (Media movie : movies) {
            outputArea.appendText(movie.getTitle() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
