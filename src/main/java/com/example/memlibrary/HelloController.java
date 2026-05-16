package com.example.memlibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class HelloController {

    @FXML
    Button iconButton1, playButton;
    @FXML
    ImageView mainImageView;
    @FXML
    TextArea descriptionArea;
    @FXML
    VBox iconContainer;

    MediaPlayer mediaPlayer;
    
    public void iconButton1Clicked(ActionEvent event) {

    }

    public void playAudio(ActionEvent event) {

        try {

            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            String audio = getClass().getResource("/audio/40grn.mp3").toExternalForm();
            Media media = new Media(audio);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
