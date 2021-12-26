package UserInterface;

import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class settingsController  {

    private Main main;

    @FXML
    private TextField excelPathField;

    @FXML
    private void clickSetExcel () {
//        FileChooser chooser = new FileChooser();
//        chooser.setTitle("Path to Saving Excel");
//        chooser.
//        File selectedFile = chooser.showOpenDialog(Main.primaryStage);
        DirectoryChooser chooser = new DirectoryChooser();
        File selectedDirectory = chooser.showDialog(Main.primaryStage);
        excelPathField.setText(selectedDirectory.getAbsolutePath());
    }


}
