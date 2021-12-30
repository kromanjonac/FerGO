package InputLocal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ManualEndController implements Initializable {

    @FXML
    Button generateBtn;

    @FXML
    Label confirmLabel;

    @FXML
    public void clickGenerate () {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmLabel.setVisible(false);
    }
}
