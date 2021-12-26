package UserInterface;

import MainPackage.Main;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;

public class MainMenuController {

    @FXML
    ImageView gear;

    private Main main;

    @FXML
    private void clickCreateRac () throws IOException {
        main.showArgsInput();
    }

    private void clickRunRac (){

    }

    @FXML
    private void clickGear () throws IOException {
        main.showSettings();
    }

    public void gearRotationEnter () {
        RotateTransition transition = new RotateTransition(Duration.seconds(0.5),gear);
        transition.setFromAngle(0);
        transition.setToAngle(90);
        transition.setAutoReverse(true);
        transition.play();
    }

    public void gearRotationExit () {
        RotateTransition transition = new RotateTransition(Duration.seconds(0.5),gear);
        transition.setFromAngle(90);
        transition.setToAngle(0);
        transition.setAutoReverse(true);
        transition.play();
    }



}
