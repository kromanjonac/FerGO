package UserInterface;


import MainPackage.Main;
import Utils.FileUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CreateChoiceController {

    @FXML
    Button excelBtn;


    @FXML
    private void generateLocally () throws IOException {
        Main.goingForward = true;
        Main.currentTeam = 1;
        Main.showInputLocal();
    }

    @FXML
    private void generateSheet () throws IOException {
        //tu pozovi metodu za odradit exelicu, posalji path i parametre
        // zalijepi label koji potvrduje da je fajl generiran (ili ako je greska?)
        //onemoguci gumb za generirat jos

        FileUtilities.createExcelFileForRaceEvent(Main.currentEvent.getNumberOfTeams(),Main.currentEvent.getNumberOfRowers(),
                Main.currentEvent.getNumberOfErgs(),Main.currentEvent.getName(),Main.currentEvent.getLength(),Main.currentEvent.getSplits(),
                Main.excelSavePath.toString());

        excelBtn.setDisable(true);

    }




}
