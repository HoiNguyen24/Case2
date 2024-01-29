package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import src.manager.AccountManager;
import src.model.Account;

import java.io.IOException;

public class Login {
    @FXML TextField username;
    @FXML PasswordField password;
   private Stage stage;

    static AccountManager accountManager = new AccountManager();
    public static void display(){
        accountManager.read();
    }
    public void login(ActionEvent event) throws IOException {
        accountManager.read();
        String name = username.getText();
        String pass = password.getText();
        Account account = accountManager.checkLogin(name,pass);
        if(account != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menucontrol.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
