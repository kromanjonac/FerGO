package MainPackage;


import CustomClasses.RaceEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main extends Application {

    // javafx graficke varijable

public static Stage primaryStage;

private static BorderPane mainLayout;

// nasi podaci za obradu

public static RaceEvent currentEvent;

public static int currentTeam;

// putanje do spremljenih pathova

public static Path excelSavePath;

public static Path racSavePath;

public static Path listenerPath;

public static Path finalResPath;





    @Override
    public void start(Stage stage) throws Exception{

// procitaj iz fajlova ako ima
        String excel = Files.readString(Path.of("src/main/resources/ExcelSavePath.txt"));
        if (!excel.isEmpty()) excelSavePath = Path.of(excel);

        String rac = Files.readString(Path.of("src/main/resources/RacSavePath.txt"));
        if (!rac.isEmpty()) racSavePath = Path.of(rac);

        String listener = Files.readString(Path.of("src/main/resources/ListenerPath.txt"));
        if(!listener.isEmpty()) listenerPath = Path.of(listener);

        String finalRes = Files.readString(Path.of("src/main/resources/FinalResPath.txt"));
        if(!finalRes.isEmpty()) finalResPath = Path.of(finalRes);


        primaryStage = stage;
        primaryStage.setTitle("FerGO");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("LogoNonTrans.png"));
        //System.out.println(Main.class.getResource("../MainMenu.fxml"));
        showMainView();
        showDefaultCenter();

    }


    private void showMainView () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(Main.class.getResource("../UserInter"));
        mainLayout = loader.load(Main.class.getResource("../MainMenu.fxml"));
        Scene scene = new Scene(mainLayout);
        String CSS = this.getClass().getResource("../styles.css").toExternalForm();
        scene.getStylesheets().add(CSS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showDefaultCenter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../defaultCenter.fxml"));
        AnchorPane defCenter = loader.load();
        mainLayout.setCenter(defCenter);
    }

    public static void showArgsInput () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ArgsInput.fxml"));
        AnchorPane argsInp = loader.load();
        mainLayout.setCenter(argsInp);
}

    public static void showCreateChoice () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../CreateChoice.fxml"));
        AnchorPane createChoice = loader.load();
        mainLayout.setCenter(createChoice);
    }

    public static void showSettings () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../settings.fxml"));
        AnchorPane settingsPane = loader.load();
        mainLayout.setCenter(settingsPane);
    }

    public static void showInputLocal () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../InputLocal.fxml"));
        AnchorPane inputPane = loader.load();
        mainLayout.setCenter(inputPane);
    }

    public static void showManualEnd () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../manualEnd.fxml"));
        AnchorPane manualEndPane = loader.load();
        mainLayout.setCenter(manualEndPane);
    }

    public static void showExcelInput () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ExcelPane.fxml"));
        AnchorPane excelPane = loader.load();
        mainLayout.setCenter(excelPane);
    }







    public static void main(String[] args) {
        launch(args);
    }





}
