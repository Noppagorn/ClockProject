package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.management.RuntimeErrorException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalDateTime;

public class Controller {

    int hourInt = 1;
    int minuteInt = 0;

    @FXML private Label showTime;
    @FXML private Label timeAlarm;
    @FXML private Button buttonToSetTime;
    @FXML private TextField hourTextField;
    @FXML private TextField minuteTextField;
    @FXML private Button stopAlarm;
    private TimeToShow timeToShow;
    private TargetTime targetTime;
    private boolean isSoundOn = false;
    private AudioClip plonkSound;

    public Controller(){
        timeToShow = new TimeToShow();
        targetTime = new TargetTime();
    }
    @FXML
    public void initialize(){
        try {
            targetTime.setHour(8);
            targetTime.setMinute(0);
        }catch (IOException e){
            System.out.println(e);
        }
        timeAlarm.setText("ALARM : " + targetTime.getHour() + ":" + targetTime.getMinute());
        running();
    }

    @FXML
    public void running(){
        // TIME running
        System.out.println("RUN");
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            showTime.setText(timeToShow.showHours() + ":" + timeToShow.showMinute() + ":" + timeToShow.showSecond());
            if (targetTime.check(timeToShow.showHours(),timeToShow.showMinute(),0)){
                isSoundOn = true;
            }
            soundAlarm(isSoundOn);

        }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    @FXML
    public void handleButtonToSetTime(ActionEvent event){
        System.out.println("CLICK");
        try {
            hourInt = Integer.parseInt(hourTextField.getText());
            minuteInt = Integer.parseInt(minuteTextField.getText());
            System.out.println(hourInt);
            targetTime.setMinute(minuteInt);
            targetTime.setHour(hourInt);


        } catch (IOException e) {
            System.out.println(e);
        }
        hourTextField.setText("");
        minuteTextField.setText("");

        timeAlarm.setText("ALARM : " + targetTime.getHour() + ":" + targetTime.getMinute());
    }


    @FXML
    public void handlestopButton(ActionEvent event){
        System.out.println("STOP");
        isSoundOn = false;
        plonkSound.stop();
    }
    public void soundAlarm(boolean isOn){
        plonkSound = new AudioClip(Paths.get("src/sample/clock.mp3").toUri().toString());
        if(isOn)
            plonkSound.play();
        else
            plonkSound.stop();
    }

}
