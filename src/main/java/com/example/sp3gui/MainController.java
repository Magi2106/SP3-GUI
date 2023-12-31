package com.example.sp3gui;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Stage userChoices = new Stage();
    private FileIO io = new FileIO();
    private Media media;
    @FXML
    private ListView<String> ListView1 = new ListView<String>();
    @FXML
    private ListView<String> ListView2 = new ListView<String>();
    @FXML
    private ListView<String> ListView3 = new ListView<String>();
    private User currentUser = LoginController.currentUser;

    @Override
    public void initialize(URL var1, ResourceBundle var2) {
        loadLists();

    }

    private String getSelectedMovie() {
        String selectedFromListView1 = ListView1.getSelectionModel().getSelectedItem();
        String selectedFromListView2 = ListView2.getSelectionModel().getSelectedItem();
        String selectedFromListView3 = ListView3.getSelectionModel().getSelectedItem();

        // Return the selected item from any ListView or null if none is selected
        return selectedFromListView1 != null ? selectedFromListView1 :
                selectedFromListView2 != null ? selectedFromListView2 :
                        selectedFromListView3;

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
        ObservableList<String> seriesList = FXCollections.observableArrayList();
        ObservableList<String> movieList = FXCollections.observableArrayList();
        ObservableList<String> savedMedias = FXCollections.observableArrayList();

        for (Media movie : movies) {
            movieList.addAll(movie.getTitle());
        }
        ListView1.getItems().addAll(movieList);

        for (Media serie : series) {
            seriesList.add(serie.getTitle());
        }
        ListView2.getItems().addAll(seriesList);

        if (currentUser != null) {
            List<String> savedMedia =  currentUser.getSavedMedia();
            ListView3.getItems().addAll(savedMedia);
        }
    }

    private void SearchMedia(List<Object> list, String Search) {
        // TODO
    }

    private void addSavedMedia(String movie) throws IOException {
        currentUser.getSavedMedia().add(movie);
        io.saveMediaList(currentUser);
    }

    // Logs out of user and returns to Login screen.
    @FXML
    private void LogOutButton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            userChoices.setScene(new Scene(root));
            userChoices.setResizable(false);
            userChoices.show();
        } catch (IOException e) {
            showErrorDialog("Logout", "Logged out");
        }
    }

    @FXML
    private void saveMedia(ActionEvent event) {
        String selectedMovie = getSelectedMovie();
        if (selectedMovie != null) {
            try {
                addSavedMedia(selectedMovie);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private void WatchButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MediaPlayer.fxml"));
            Parent root = loader.load();
            userChoices.setScene(new Scene(root));
            userChoices.setResizable(false);
            userChoices.show();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

