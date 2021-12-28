package UserInterface;


import MainPackage.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class CreateChoiceController {


    @FXML
    private void generateLocally () throws IOException {
        Main.currentTeam = 1;
        Main.showInputLocal();
    }

    @FXML
    private void generateSheet () {
        //tu pozovi metodu za odradit exelicu, posalji path i parametre
        // zalijepi label koji potvrduje da je fajl generiran (ili ako je greska?)
        //onemoguci gumb za generirat jos
    }




}
