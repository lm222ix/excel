package GUI;/**
 * Created by ludde on 2015-10-23.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fucking statistics mang");
        BorderPane pane = new BorderPane();
        primaryStage.setScene(new Scene(pane, 800, 500));
        primaryStage.show();
    }
}
