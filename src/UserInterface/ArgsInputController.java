package UserInterface;


import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ArgsInputController implements Initializable {

    private Main main;

    Integer[] numOfItems = {1,2,3,4,5,6,7,8};

    @FXML
    ChoiceBox<Integer> teamsBox;
    @FXML
    ChoiceBox<Integer> rowersBox;
    @FXML
    ChoiceBox<Integer> ergsBox;
//    @FXML
//    Button confirmBtn;

    private void confirmBtnClick() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        teamsBox.getItems().addAll(numOfItems);
        rowersBox.getItems().addAll(numOfItems);
        ergsBox.getItems().addAll(numOfItems);
    }
}
