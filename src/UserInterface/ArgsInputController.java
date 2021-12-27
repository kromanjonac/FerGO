package UserInterface;


import CustomClasses.RaceEvent;
import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArgsInputController implements Initializable {

    private Main main;

    Integer[] numOfItems = {1,2,3,4,5,6,7,8};
    Integer[] numOfSplits = {1,2,4};


    @FXML
    TextField raceLengthField = new TextField();

    @FXML
    TextField eventNameField = new TextField();



    @FXML
    ChoiceBox<Integer> splitsBox;

    @FXML
    TextField teamsField = new TextField();

//    @FXML
//    ChoiceBox<Integer> teamsBox;
    @FXML
    ChoiceBox<Integer> rowersBox;
    @FXML
    ChoiceBox<Integer> ergsBox;
//    @FXML
//    Button confirmBtn;


    @FXML
    private void confirmBtnClick() throws IOException {
       // int teams = teamsBox.getValue();
        int rowers = rowersBox.getValue();
        int ergs = ergsBox.getValue();
        int splits = splitsBox.getValue();
        if (eventNameField.getText().trim().isEmpty()) return;
        Main.currentEvent = new RaceEvent(Integer.parseInt(teamsField.getText()),rowers,ergs,eventNameField.getText().trim(),Integer.parseInt(raceLengthField.getText()),splits);
        main.showCreateChoice();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //teamsBox.getItems().addAll(numOfItems);
        rowersBox.getItems().addAll(numOfItems);
        ergsBox.getItems().addAll(numOfItems);
        splitsBox.getItems().addAll(numOfSplits);
    }
}
