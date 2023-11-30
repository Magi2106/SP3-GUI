package com.example.sp3gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Main extends Application {

    MainController mainController;
    public static void main(String[] args) {
        launch(args);

    }
// 1. LAV SAVED MEDIA LISTE SÅ MAN KAN SE DEN / DEN OPDATERE SIG SELV.
// 2. GUstav CLEANER LORTET UP SÅ DET SER BANGER UD OG LIGNER PORNHUB!
// 3. Save metoder til user watched/saved media.


    @Override
    public void start(Stage primaryStage) throws IOException {


        FileInputStream input = new FileInputStream("shrek.png");
        Image image = new Image(input);
        ImageView i = new ImageView(image);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Pane root = fxmlLoader.load();
        Pane background = new Pane();
        Group group = new Group();

        background.getChildren().add(i);
        group.getChildren().add(i);
        group.getChildren().add(root);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.show();



    }
}








