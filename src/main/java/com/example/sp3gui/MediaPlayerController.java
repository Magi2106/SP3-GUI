package com.example.sp3gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaPlayerController implements Initializable{
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playButton, pauseButton, resetButton;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        file = new File("Media/Videomaterial.m4v");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    @FXML
    private void playMedia() {
        mediaPlayer.play();
    }

    @FXML
    private void pauseMedia() {
        mediaPlayer.pause();
    }

    @FXML
    private void resetMedia() {
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }
}