package com.example.sp3gui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private FileIO io = new FileIO();
    private Media media;
    private User currentUser;
    @FXML
    Stage userChoices = new Stage();
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextArea outputArea;

    public ListView<String> ListView1 = new ListView<String>();
    public ListView<String> ListView2 = new ListView<String>();
    public ListView<String> ListView3 = new ListView<String>();

    @Override
    public void initialize(URL var1, ResourceBundle var2) {
        loadLists();

    }

    // Loads ViewLists.
    private void loadLists() {
        List<Media> movies = io.loadMovies();
        List<Media> series = io.loadSeries();
        List<String> savedMedia;
        ObservableList<String> seriesList = FXCollections.observableArrayList();
        ObservableList<String> movieList = FXCollections.observableArrayList();
        ObservableList<String> savedMedias = FXCollections.observableArrayList();

        for (Media movie : movies) {
            movieList.add(movie.getTitle());
        }
        ListView1.getItems().addAll(movieList);


        for (Media serie : series) {
            seriesList.add(serie.getTitle());
        }
        ListView2.getItems().addAll(seriesList);

        // TODO: Add user SavedMedia > savedMedias > ListView3

    }

    // Logs into existing user.
    @FXML
    void loginPressed(ActionEvent event) {

        try {
            currentUser = io.login(usernameField.getText(), passwordField.getText());

            if (currentUser != null) {
                Platform.runLater(() -> {

                    try {
                        ((Node)(event.getSource())).getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root = loader.load();
                        userChoices.setScene(new Scene(root, 800, 600));
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error1", "An error occurred while loading the next screen.");
                    }
                });

            } else {
                showErrorDialog("Error2", "An error occurred while loading the next screen.");
            }
        } catch (FileNotFoundException e) {
            showErrorDialog("Error3", "An unexpected error occured: " + e.getMessage());

        } catch (Exception e) {
            showErrorDialog("Error4", "An unexpected error occured: " + e.getMessage());
        }
    }



    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Creates a new user.
    @FXML
    private void registerPressed(ActionEvent event) {
        try {
            io.createUser(usernameField.getText(), passwordField.getText(), 0);

            if (currentUser != null) {

                Platform.runLater(() -> {

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root = loader.load();
                        userChoices.setScene(new Scene(root, 800, 600));
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error1", "An error occurred while loading the next screen.");
                    }
                });

            } else {
                showErrorDialog("Error2", "An error occurred while loading the next screen.");
            }
        } catch (Exception e) {
            showErrorDialog("Error3", "An unexpected error occured: " + e.getMessage());
        }
    }


    @FXML
    private void LogOutButton(ActionEvent event) throws FileNotFoundException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            userChoices.setScene(new Scene(root, 800, 600));
            userChoices.show();

        } catch (IOException e) {
            showErrorDialog("Logout", "Logged out");
        }
        gigaShrek();
    }

public void gigaShrek() throws FileNotFoundException {

    FileInputStream input = new FileInputStream("shrek.png");
    Image image = new Image(input);
    ImageView i = new ImageView(image);

    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

    Pane background = new Pane();
    Pane root = new Pane();
    Group group = new Group();

    background.getChildren().add(i);
    group.getChildren().add(i);
    group.getChildren().add(root);
    Scene scene = new Scene(group);

    userChoices.setScene(scene);
    userChoices.show();

    //return scene;
}


}



/*

        ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentMovie = ListView.getSelectionModel().getSelectedItem();


*/
