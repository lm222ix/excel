package GUI;/**
 * Created by ludde on 2015-10-23.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("MoneyTracker");
        BorderPane pane = new BorderPane();

        final ContextMenu listViewContextMenu = new ContextMenu();
        MenuItem menuItemAddToList = new MenuItem("Add new");
        menuItemAddToList.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("triggered.");
                AddNewListItemWindow window = AddNewListItemWindow.getInstance();
                window.show();
                window.toFront();
            }
        });
        listViewContextMenu.getItems().addAll(menuItemAddToList);


        final ListView leftSideLV = new ListView();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Test", "Test numba 2");
        leftSideLV.setItems(items);
        leftSideLV.setPrefWidth(200);
        leftSideLV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    listViewContextMenu.show(leftSideLV, null,event.getX()+5,event.getY()-10);
                }
            }
        });
                pane.setLeft(leftSideLV);
        primaryStage.setScene(new Scene(pane, 800, 500));
        primaryStage.show();
    }
}
