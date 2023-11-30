package com.example.sp3gui;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;




public class MainController implements Initializable {

    public Stage userChoices = new Stage();



    @FXML
    public ListView<String> ListView1 = new ListView<String>();
    public ListView<String> ListView2 = new ListView<String>();
    public ListView<String> ListView3 = new ListView<String>();

    private FileIO io = new FileIO();
    private TextUI ui;
    private Chill ch;
    private User currentUser;
    private TextArea outputArea;
    private Media media;


    //Buttons and textfields to handle login.
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private List<Media> movies = io.loadMovies();
    private List<Media> series = io.loadSeries();
    private List<Media> allMedia = io.loadList();


    @FXML
    private Label myLabel;

   // public ArrayList<String> savedMedia = currentUser.getSavedMedia();





    @FXML
    void loginPressed(ActionEvent event) {

        try {
            currentUser = io.login(usernameField.getText(), passwordField.getText());


            if (currentUser != null) {


                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root = loader.load();

                        // Create new stage to display user choices.
                        Stage userChoices = new Stage();

                        // Define scene size and show scene.
                        userChoices.setScene(new Scene(root, 800, 600));
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error", "An error occurred while loading the next screen.");
                    }
                });

            } else {
                showErrorDialog("Error", "An error occurred while loading the next screen.");
            }
        } catch (FileNotFoundException e) {
            showErrorDialog("Error", "An unexpected error occured: " + e.getMessage());

        } catch (Exception e) {
            showErrorDialog("Error", "An unexpected error occured: " + e.getMessage());
        }
    }



    @Override
    public void initialize(URL var1, ResourceBundle var2) {

       User u = currentUser;
        //  String[] moviesArr = {"Godfather", "EtEllerAndet", "OkOk"};

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

        for(String saved : savedMedias) {



        }





        /*
        Movie currentMovie = null;

        ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentMovie = ListView.getSelectionModel().getSelectedItem();

                myLabel.setText(currentMovie);

            }
        });
    }

         */

    }




/*
        @FXML
        void loginPressed(ActionEvent event) {
            try {
                currentUser = io.login(usernameField.getText(), passwordField.getText());


                if (currentUser != null) {



                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                            Parent root = loader.load();

                            // Create new stage to display user choices.


                            // Define scene size and show scene.
                            userChoices.setScene(new Scene(root, 800, 600));
                            userChoices.show();

                        } catch (IOException e) {
                            showErrorDialog("Error", "An error occurred while loading the next screen.");
                        }


                    } else {
                        showErrorDialog("Error", "An error occurred while loading the next screen.");
                    }
                } catch (FileNotFoundException e) {
                    showErrorDialog("Error", "An unexpected error occured: " + e.getMessage());

                } catch (Exception e) {
                    showErrorDialog("Error", "An unexpected error occured: " + e.getMessage());
                }
            }

 */


    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Creates a new user
    // Loads user with io.login given the information from created user.
    @FXML
    void registerPressed(ActionEvent event) {
        try {
            io.createUser(usernameField.getText(), passwordField.getText(), 0);

            if (currentUser != null) {


                Platform.runLater(() -> {

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root = loader.load();

                        // Create new stage to display user choices.
                        Stage userChoices = new Stage();

                        // Define scene size and show scene.
                        userChoices.setScene(new Scene(root, 800, 600));
                        userChoices.show();


                    } catch (IOException e) {
                        showErrorDialog("Error", "An error occurred while loading the next screen.");
                    }
                });

            } else {
                showErrorDialog("Error", "An error occurred while loading the next screen.");
            }
        } catch (Exception e) {
            showErrorDialog("Error", "An unexpected error occured: " + e.getMessage());
        }
    }
/*

    @FXML
    public void displayMedia() throws IOException {

        for (Media media : movies) {
            mediaList.add(media.getTitle());
            System.out.println(media.getTitle());
        }




    }


/*
    List<Object> searchMedia(List<Object> list, String search) {

        // final List<Object> chooseMedia = type.equals("movie") ? "txt/100bedstefilm.txt" : "txt/100bedsteserier.txt";
        // type == genre, movie, serier, rating etc.
        // parse og returner fitting list
        // switch case ?


        return list;
    }
*/

    // Search for movie or series.

    @FXML
    public void handleButton1(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MediaView.fxml"));
        Parent root = loader.load();

        // Create new stage to display user choices.
        Stage userChoices = new Stage();

        // Define scene size and show scene.
        userChoices.setScene(new Scene(root, 800, 600));
        userChoices.show();

    }

    public void LogOutButton(ActionEvent actionEvent) {

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
    String currentMovie;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


        ListView.getItems().addAll(moviesArr);

        ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentMovie = ListView.getSelectionModel().getSelectedItem();

                myLabel.setText(currentMovie);

            }
        });
    }
}

*/
