package SettingsPaths;


import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class settingsController  {



    @FXML
    private TextField excelPathField;

    @FXML
    private TextField racPathField;

    @FXML
    private TextField listenerPathField;

    @FXML
    private TextField resultsPathField;

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

    @FXML
    private void clickSetRac () {
        DirectoryChooser chooser = new DirectoryChooser();
        File selectedDirectory = chooser.showDialog(Main.primaryStage);
        racPathField.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML
    private void clickListenerPath () {
        DirectoryChooser chooser = new DirectoryChooser();
        File selectedDirectory = chooser.showDialog(Main.primaryStage);
        listenerPathField.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML
    private void clickResultPath () {
        DirectoryChooser chooser = new DirectoryChooser();
        File selectedDirectory = chooser.showDialog(Main.primaryStage);
        resultsPathField.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML
    private void clickApply () throws IOException {

        if(!excelPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/main/resources/ExcelSavePath.txt");
            writer.write(excelPathField.getText().trim());
            writer.flush();
            writer.close();
            Main.excelSavePath = Path.of(excelPathField.getText());
        }
        if (!racPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/main/resources/RacSavePath.txt");
            writer.write(racPathField.getText().trim());
            writer.flush();
            writer.close();
            Main.racSavePath = Path.of(racPathField.getText());
        }
        if(!listenerPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/main/resources/ListenerPath.txt");
            writer.write(listenerPathField.getText().trim());
            writer.flush();
            writer.close();
            Main.listenerPath = Path.of(listenerPathField.getText());
        }
        if(!resultsPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/main/resources/FinalResPath.txt");
            writer.write(resultsPathField.getText().trim());
            writer.flush();
            writer.close();
            Main.finalResPath = Path.of(resultsPathField.getText());
        }
    }

    @FXML
    public void showCurrentSettings () {
        excelPathField.setText(Main.excelSavePath.toString());
        racPathField.setText(Main.racSavePath.toString());
        listenerPathField.setText(Main.listenerPath.toString());
        resultsPathField.setText(Main.finalResPath.toString());
    }


}