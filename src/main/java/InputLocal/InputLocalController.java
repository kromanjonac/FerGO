package InputLocal;

import CustomClasses.Rower;
import CustomClasses.Team;
import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class InputLocalController implements Initializable {

    List<TextField> fieldList;

    @FXML
    Label teamNumberLabel;

    @FXML
    TextField rowerField1;

    @FXML
    TextField rowerField2;

    @FXML
    TextField rowerField3;

    @FXML
    TextField rowerField4;

    @FXML
    TextField rowerField5;

    @FXML
    TextField rowerField6;

    @FXML
    TextField rowerField7;

    @FXML
    TextField rowerField8;

    @FXML
    TextField shortTeamField;

    @FXML
    TextField teamNameField;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        teamNumberLabel.setText(String.valueOf(Main.currentTeam));
        fieldList = new LinkedList<>();
        fieldList.add(rowerField1);
        fieldList.add(rowerField2);
        fieldList.add(rowerField3);
        fieldList.add(rowerField4);
        fieldList.add(rowerField5);
        fieldList.add(rowerField6);
        fieldList.add(rowerField7);
        fieldList.add(rowerField8);

        for (int i = fieldList.size(); i > Main.currentEvent.getNumberOfRowers(); i--) {
            fieldList.get(i - 1).setVisible(false);
        }
        for (int i = 0; i < Main.currentEvent.getNumberOfRowers(); i++) {
            fieldList.get(i).setPromptText("Rower number " + (i+1)); //to set the hint text
            fieldList.get(i).getParent().requestFocus();
        }
    }
    
    @FXML
    public void clickNext() throws IOException {
        // check if false input
        if (teamNameField.getText().isEmpty()) return;
        for (int i = 0; i < Main.currentEvent.getNumberOfRowers(); i++) {
            if (fieldList.get(i).getText().trim().isEmpty()) return;
        }


        //create new team
        Team team = new Team(teamNameField.getText());
        for (var currentRower: fieldList) {
            Rower rower = new Rower(currentRower.getText().trim());
            team.setRower(rower);
        }

        if (shortTeamField.getText().isEmpty()) {
            return;
//            team.setShortName(shortTeamField.getText().trim()); // check if necessary
        }
        team.setShortName(shortTeamField.getText().trim());

        Main.currentEvent.addTeam(team);
        Main.currentTeam++;

        if (Main.currentTeam > Main.currentEvent.getNumberOfTeams()) {
        Main.showManualEnd();
        }
        else Main.showInputLocal();

    }

    @FXML
    public void clickBack() throws IOException {
        if (Main.currentTeam == 1) {
            Main.isInputLocal = false;
            Main.showCreateChoice();
        }
        else {
            Main.currentTeam--;
            Main.currentEvent.removeTeam();
            Main.showInputLocal();
        }

    }
}
