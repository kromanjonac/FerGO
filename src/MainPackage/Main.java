package MainPackage;

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

public class Main extends Application {

private Stage primaryStage;

private static BorderPane mainLayout;





    @Override
    public void start(Stage stage) throws Exception{

       // Font.loadFont("src/RobotoMono-VariableFont_wght.ttf", 20);


//        Parent root = FXMLLoader.load(getClass().getResource("../UserInterface/MainMenu.fxml"));
//        Scene scene = new Scene(root);
//
//
//        //scene.getStylesheets().add(getClass().getResource("../UserInterface/styles.css").toExternalForm());
           // String CSS = this.getClass().getResource("../UserInterface/styles.css").toExternalForm();
//
//
//        //working setup
//        scene.getStylesheets().add(CSS);
//        stage.setMinWidth(1000);
//        stage.setMinHeight(600);
//        stage.setTitle("FerGO");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.getIcons().add(new Image("LogoNonTrans.png"));
//
//        stage.show();

        //DO TUD RADI

        Font roboto = Font.loadFont(Main.class.getResource("RobotoMono-Medium.ttf").toExternalForm(),40);
        primaryStage = stage;
        primaryStage.setTitle("FerGO");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        primaryStage.setTitle("FerGO");
        //stage.setScene(scene);
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







    public static void main(String[] args) {
        launch(args);
    }





}
