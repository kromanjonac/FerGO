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
import java.util.ResourceBundle;

public class settingsController  {

    private Main main;

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
        System.out.println(excelPathField.getText().trim());
        if(!excelPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/SettingsPaths/ExcelSavePath.txt");
            writer.write(excelPathField.getText().trim());
            writer.flush();
            writer.close();
        }
        if (!racPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/SettingsPaths/RacSavePath.txt");
            writer.write(racPathField.getText().trim());
            writer.flush();
            writer.close();
        }
        if(!listenerPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/SettingsPaths/ListenerPath.txt");
            writer.write(listenerPathField.getText().trim());
            writer.flush();
            writer.close();
        }
        if(!resultsPathField.getText().trim().isEmpty()) {
            FileWriter writer = new FileWriter("src/SettingsPaths/FinalResPath.txt");
            writer.write(resultsPathField.getText().trim());
            writer.flush();
            writer.close();
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
