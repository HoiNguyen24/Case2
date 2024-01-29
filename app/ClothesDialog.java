package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import src.manager.ClothesManager;
import src.model.Clothes;
import src.model.Dates;
import src.validate.AccountValidate;
import src.validate.ClothesValidate;

import java.io.IOException;
import java.util.Optional;

public class ClothesDialog extends Application {
    private Clothes clothes;

    ClothesManager clothesManager = new ClothesManager();
    @FXML private TextField clothescode = new TextField();
    @FXML private TextField clothesname = new TextField();
    @FXML private TextField clothestype = new TextField();
    @FXML private TextField clothescolor = new TextField();
    @FXML private TextField clothesprice = new TextField();
    @FXML private TextField clothesquantity = new TextField();
    Dialog<Clothes> dialog = new Dialog<>();

    public Dialog<Clothes> getDialog(){
        return dialog;
    }

    public ClothesDialog() throws IOException {
        super();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/addinfo.fxml"));
        loader.setController(this);
        DialogPane dialogPane = (DialogPane) loader.load();
        dialog.setDialogPane(dialogPane);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
        Button addButton =(Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        clothesManager.read();
        System.out.println("2");
        addButton.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!ValidateClothes()){
                    event.consume();
                }
            }
            private boolean ValidateClothes(){
                if(!ClothesValidate.checkName(clothesManager.getClothes(),clothesname.getText()) ||
                        !ClothesValidate.checkCode(clothesManager.getClothes(),clothescode.getText()) ||
                         clothestype.getText().isEmpty() ||
                         clothescolor.getText().isEmpty() ||
                         clothesprice.getText().isEmpty() ||
                         clothesquantity.getText().isEmpty())
                    return false;
                return true;
            }
        });
        System.out.println("3");
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK)
                return new Clothes(clothesname.getText(),clothestype.getText(),clothescolor.getText(),Long.parseLong(clothesprice.getText()),Long.parseLong(clothesquantity.getText()),clothescode.getText(),new Dates());
            return null;
        });
    }
    @Override
    public void start(Stage stage) throws Exception {

    }


}
