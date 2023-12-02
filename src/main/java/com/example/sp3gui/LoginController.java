package com.example.sp3gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    ImageView Image1 = new ImageView();
    @FXML
    Stage userChoices = new Stage();
    private FileIO io = new FileIO();
    private User currentUser;
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

    @Override
    public void initialize(URL var1, ResourceBundle var2) {
        Image image = new Image("file:src/main/java/com/example/sp3gui/ShrekTitle.jpeg");
        Image1.setImage(image);


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


}
