package MainPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

       // Font.loadFont("src/RobotoMono-VariableFont_wght.ttf", 20);


        Parent root = FXMLLoader.load(getClass().getResource("../UserInterface/MainMenu.fxml"));
        Scene scene = new Scene(root);


        //scene.getStylesheets().add(getClass().getResource("../UserInterface/styles.css").toExternalForm());
        String menuCSS = this.getClass().getResource("../UserInterface/styles.css").toExternalForm();
        scene.getStylesheets().add(menuCSS);
        stage.setTitle("FerGO");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
