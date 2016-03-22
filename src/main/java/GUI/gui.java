package GUI;/**
 * Created by ludde on 2015-10-23.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CollectedDataObject;
import model.Purchase;

public class gui extends Application {


    final ListView leftSideLV = new ListView();
    final TableView<Purchase> purchasesTableView = new TableView();
    final TableView<Purchase> chargersTableView = new TableView();
    ObservableList<CollectedDataObject> items = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("MoneyTracker");
        BorderPane pane = new BorderPane();

        final ContextMenu listViewContextMenu = new ContextMenu();
        MenuItem menuItemAddToList = new MenuItem("Add new");
        menuItemAddToList.setOnAction((event -> {
           // AddNewListItemWindow window = AddNewListItemWindow.getInstance();
            AddNewListItemWindow window = new AddNewListItemWindow();
            window.showAndWait();
            window.toFront();
            items.add(window.getDataObject());
        }));

        listViewContextMenu.getItems().addAll(menuItemAddToList);

        leftSideLV.setItems(items);
        leftSideLV.setPrefWidth(200);

        leftSideLV.getSelectionModel().selectedItemProperty().addListener(observable -> {
            CollectedDataObject selected = (CollectedDataObject) leftSideLV.getSelectionModel().getSelectedItem();
            if(selected != null) {
                ObservableList<Purchase> purchases = FXCollections.observableArrayList(selected.getM_purchases());
                purchasesTableView.setItems(purchases);
            }
        });

        leftSideLV.setOnMouseClicked(event ->  {
            if(event.getButton() == MouseButton.PRIMARY) {
                System.out.println("leftclicked on " + leftSideLV.getSelectionModel().getSelectedItem());
                if(listViewContextMenu.isShowing()) {
                    listViewContextMenu.hide();
                }
            }
            else if (event.getButton() == MouseButton.SECONDARY) {
                System.out.println("rightclicked on " + leftSideLV.getSelectionModel().getSelectedItem());
                if(leftSideLV.getSelectionModel().getSelectedItem() != null) {
                    leftSideLV.getSelectionModel().clearSelection();
                } else {
                    listViewContextMenu.show(leftSideLV, null, event.getX() + 5, event.getY() - 10);
                }
            }
        });



        //top

        //Radios
        ToggleGroup tg = new ToggleGroup();
        RadioButton purchasesModeRadio = new RadioButton("View all purchases");
        purchasesModeRadio.setOnAction(event -> {
            pane.setRight(purchasesTableView);
        });
        purchasesModeRadio.setToggleGroup(tg);
        purchasesModeRadio.setSelected(true);
        RadioButton chargerModeRadio = new RadioButton("View by chargers");
        chargerModeRadio.setOnAction(event -> {
            pane.setRight(chargersTableView);
        });




        chargerModeRadio.setToggleGroup(tg);
        //Container
        HBox radioContainer = new HBox(10);

       // radioContainer.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        radioContainer.getChildren().addAll(purchasesModeRadio,chargerModeRadio);
        radioContainer.setAlignment(Pos.CENTER_RIGHT);
        radioContainer.setPadding(new Insets(15,25,10,10));

        //VBox
        VBox topBar = new VBox ();
        //topBar.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        topBar.setPrefHeight(50);
        topBar.setPrefWidth(50);
        topBar.getChildren().addAll(radioContainer);


        //Right side, TableView
        purchasesTableView.setPrefWidth(300);
        TableColumn<Purchase,String> date = new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory("date"));
        TableColumn<Purchase,Double> amount = new TableColumn<>("Amount");
        amount.setCellValueFactory(new PropertyValueFactory("amount"));
        TableColumn<Purchase,String> charger = new TableColumn<>("Charger");
        charger.setCellValueFactory(new PropertyValueFactory("charger"));
        purchasesTableView.getColumns().setAll(date,amount,charger);


        //Chargers
        chargersTableView.setPrefWidth(300);
        TableColumn<Purchase,String> chargerName = new TableColumn<>("Charger");
        date.setCellValueFactory(new PropertyValueFactory("chargerName"));
        TableColumn<Purchase,Double> chargerIncome = new TableColumn<>("Income");
        amount.setCellValueFactory(new PropertyValueFactory("chargerIncome"));
        TableColumn<Purchase,String> chargerOutcome = new TableColumn<>("Outcome");
        charger.setCellValueFactory(new PropertyValueFactory("chargerOutcome"));
        chargersTableView.getColumns().setAll(chargerName,chargerIncome,chargerOutcome);


        pane.setTop(topBar);
        pane.setRight(purchasesTableView);
            pane.setLeft(leftSideLV);
        primaryStage.setScene(new Scene(pane, 1200, 500));
        primaryStage.show();
    }
}
