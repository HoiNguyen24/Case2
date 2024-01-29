package app;

import app.ClothesDialog;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.manager.ClothesManager;
import src.model.Clothes;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClothesMenu extends Application implements Initializable{
    ClothesManager clothesManager = new ClothesManager();
    @FXML private TableView<Clothes> table = new TableView<>();
    @FXML private TableColumn<Clothes,String> IdColumn;
    @FXML private TableColumn<Clothes,String> NameColumn;
    @FXML private TableColumn<Clothes,String> ColorColumn;
    @FXML private TableColumn<Clothes,String> TypeColumn;
    @FXML private TableColumn<Clothes,Long> PriceColumn;
    @FXML private TableColumn<Clothes,Long> QuantityColumn;
    @FXML Button addButton;
    ObservableList<Clothes> clothesObservableList;

    public static void main(String[] args) {
        launch(args);
    }
    @FXML public void add() throws IOException {
        ClothesDialog clothesDialog  = new ClothesDialog();
        Dialog<Clothes> clothesDialogD = clothesDialog.getDialog();
        Optional<Clothes> result = clothesDialogD.showAndWait();
        result.ifPresent(clothes -> {
            System.out.println(clothes.toString());
        });
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/clothesmenu.fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clothesManager.read();
        clothesObservableList = FXCollections.observableArrayList(clothesManager.getClothes());
        IdColumn.setCellValueFactory(new PropertyValueFactory<Clothes,String>("code"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<Clothes,String>("name"));
        ColorColumn.setCellValueFactory(new PropertyValueFactory<Clothes,String>("color"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<Clothes,String>("type"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<Clothes,Long>("price"));
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<Clothes,Long>("quantity"));
        table.setItems(clothesObservableList);
    }
}
