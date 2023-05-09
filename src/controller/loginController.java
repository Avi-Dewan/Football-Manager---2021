package controller;

import Collections.Club;
import Main.Main;
import Util.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class loginController {



    private Main main;

    @FXML
    public TextField clubName;

    @FXML
    public PasswordField pass;

    @FXML
    public void login(ActionEvent event) {
        String cName = clubName.getText();
        String password = pass.getText();

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(cName);
        loginDTO.setPassword(password);

        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void reset(ActionEvent event) {
        clubName.setText(null);
        pass.setText(null);
    }

    @FXML
    public void exitProgram() throws IOException {
        exit(0);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
