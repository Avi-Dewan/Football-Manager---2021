package Main;

import Collections.*;
import controller.loginController;
import controller.mainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private NetworkUtil networkUtil;
    private String clientName;

    public static Club club = new Club();
    public static List<Player> marketList = new ArrayList<>();


    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThreadClient(this);
    }

    public void showLoginPage() throws Exception {

        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        loginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 1250, 800));
        stage.show();
    }

    public void showMainPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/mainMenu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        mainController controller = loader.getController();
        controller.setMain(this);
        controller.init();


        // Set the primary stage
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 1250, 800));
        stage.show();
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
