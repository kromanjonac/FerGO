package MainPackage;

import CustomClasses.RaceEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Path;

public class Main extends Application {

public static Stage primaryStage;

private static BorderPane mainLayout;

public static RaceEvent currentEvent;

public static Path excelSaveDir;

public static Path racListener;


    @Override
    public void start(Stage stage) throws Exception{

        primaryStage = stage;
        primaryStage.setTitle("FerGO");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        primaryStage.setTitle("FerGO");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("LogoNonTrans.png"));

        showMainView();
        showDefaultCenter();

    }


    private void showMainView () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../UserInterface/MainMenu.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        String CSS = this.getClass().getResource("../UserInterface/styles.css").toExternalForm();
        scene.getStylesheets().add(CSS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showDefaultCenter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../UserInterface/defaultCenter.fxml"));
        AnchorPane defCenter = loader.load();
        mainLayout.setCenter(defCenter);
    }

    public static void showArgsInput () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../UserInterface/ArgsInput.fxml"));
        AnchorPane argsInp = loader.load();
        mainLayout.setCenter(argsInp);
}

    public static void showCreateChoice () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../UserInterface/CreateChoice.fxml"));
        AnchorPane createChoice = loader.load();
        mainLayout.setCenter(createChoice);
    }

    public static void showSettings () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../UserInterface/settings.fxml"));
        AnchorPane settingsPane = loader.load();
        mainLayout.setCenter(settingsPane);
    }






    public static void main(String[] args) {
        launch(args);
    }





}
