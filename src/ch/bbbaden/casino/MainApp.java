/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import ch.bbbaden.casino.login.LoginController;
import ch.bbbaden.casino.login.SignUpController;
import ch.bbbaden.casino.mainmenu.*;
import ch.bbbaden.casino.blackjack.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author misch
 */
public class MainApp extends Application {

    Stage stage;
    User user;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        showLogin();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void showMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/MainMenu.fxml"));
            Parent root;
            root = loader.load();
            MainMenuController view = loader.getController();

            MainMenuViewModel viewModel = new MainMenuViewModel(user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            view.userAdmin();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLogin() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/Login.fxml"));
            Parent root;
            root = loader.load();
            LoginController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showSignUp() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/SignUp.fxml"));
            Parent root;
            root = loader.load();
            SignUpController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Registrierung");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showKasse() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/Kasse.fxml"));
            Parent root;
            root = loader.load();
            KasseController view = loader.getController();
            view.setMainApp(this);
            view.setUser(user);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Kasse");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showStatistik() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/Admin.fxml"));
            Parent root;
            root = loader.load();
            AdminController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Statistik");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showBlackjackMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("blackjack/BlackjackMenu.fxml"));
            Parent root;
            root = loader.load();
            BlackjackMenuController view = loader.getController();
            BlackjackMenuViewModel viewModel = new BlackjackMenuViewModel(user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Blackjack");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showBlackjackGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("blackjack/BlackjackGame.fxml"));
            Parent root;
            root = loader.load();
            BlackjackGameController view = loader.getController();
            BlackjackGameModel model = new BlackjackGameModel();
            BlackjackGameViewModel viewModel = new BlackjackGameViewModel(model);
            viewModel.setMainApp(this);
            model.AddPropertyChangeListener(viewModel);
            view.setViewModel(viewModel);
            view.bind();
            view.setUser(user);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Blackjack");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
