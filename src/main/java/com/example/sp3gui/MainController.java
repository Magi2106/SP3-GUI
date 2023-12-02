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

    @FXML
    Stage userChoices = new Stage();
    @FXML
    private TextArea outputArea;
    private FileIO io = new FileIO();
    private Media media;
    public ListView<String> ListView1 = new ListView<String>();
    public ListView<String> ListView2 = new ListView<String>();
    public ListView<String> ListView3 = new ListView<String>();

    @Override
    public void initialize(URL var1, ResourceBundle var2) {
        loadLists();

        // TODO: Fix user SavedMedia list.
        // Possible solutions:
        // Check if declared within initialize() works.
        // Check if splitting MainController into Login and MainController class.
        // TODO: Add method to save userMedia to FileIO with the currentUser object.
        // Get user from io.login, is it necessary to split apart classes? Other solutions?
        // Remember to call the method within ActionEvent methods, for automatic saving.
        // TODO: Add search method.
        // TODO: Clean up variable access identifiers (public/private).
        // TODO: Add poster art as user interactable buttons?
        // Use for loop and media.GetTitle.equals(poster.jpeg) to get title
        // Add buttons with for loop with a predefined button added x(movies or series) times.
        // Separate method for searching movieLists. Pass Lists into method and return new one. Redefine loadLists? Overload?
        // Refresh on every search. Call search within ActionEvent method(s) or create independent search field method?

    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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

    }

    // Logs into existing user.



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

    }
}



/*

        ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentMovie = ListView.getSelectionModel().getSelectedItem();


*/
