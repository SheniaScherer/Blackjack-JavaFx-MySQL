/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class KasseController implements Initializable {

    MainApp mainApp;
    User user;

    @FXML
    private TextField einzahlungTxt;
    @FXML
    private Button einzahlenBtn;
    @FXML
    private Button closeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void einzahlenAction(ActionEvent event) {
        //Einzahlung wird getätigt, überprüft ob Zahl eingegeben
        try {
            double einzahlung = Double.parseDouble(einzahlungTxt.getText());
            if(einzahlung > 0){
            user.setBalance(user.getBalance() + einzahlung);
            mainApp.showMainMenu();
            }else{
                JOptionPane.showMessageDialog(null,
                    "Sie können keinen negativen Betrag einzahlen!",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen eine Zahl eingeben",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    @FXML
    private void closeAction(ActionEvent event) {
        mainApp.showMainMenu();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
