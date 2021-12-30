package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.net.URL;
import java.util.ResourceBundle;

public class RunRaceController implements Initializable {
    @FXML
    TableColumn column1;

    @FXML
    TableColumn column2;

    @FXML
    TableView wholeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        column1.setSortable(false);
        column2.setSortable(false);
        wholeView.setEditable(false);
        column1.setReorderable(false);
        column2.setReorderable(false);
        wholeView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }
}
