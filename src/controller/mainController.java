package controller;


import Collections.*;
import Main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class mainController {

    private Main main;

    private ObservableList<Player> list = FXCollections.observableArrayList();
    private ObservableList<CnCount> listCnCount = FXCollections.observableArrayList();
    private ObservableList<Player> listMarket = FXCollections.observableArrayList();

    @FXML
    private TextField sName;

    @FXML
    private TextField sPosition;

    @FXML
    private TextField sCountry;

    @FXML
    private TextField sLow;

    @FXML
    private TextField sHigh;

    @FXML
    private Label name;

    @FXML
    private TableView<Player> table;

    @FXML
    private TableColumn<Player, String> tName;

    @FXML
    private TableColumn<Player, String> tPos;

    @FXML
    private TableColumn<Player, Integer> tNum;

    @FXML
    private TableColumn<Player, Integer> tAge;

    @FXML
    private TableColumn<Player, String> tCn;

    @FXML
    private TableColumn<Player, Double> tHeight;

    @FXML
    private TableColumn<Player, Double> tSalary;

    @FXML
    private TableView<CnCount> table2;

    @FXML
    private TableColumn<CnCount, String> t2countryName;

    @FXML
    private TableColumn<CnCount, Integer> t2PlayersCount;

    @FXML
    private TableView<Player> marketTable;

    @FXML
    private TableColumn<Player, String> mName;

    @FXML
    private TableColumn<Player, String> mPos;

    @FXML
    private TableColumn<Player, String> mCountry;

    @FXML
    private TableColumn<Player, Integer> mAge;

    @FXML
    private TableColumn<Player, String> mCLub;

    @FXML
    private TableColumn<Player, Double> mPrice;

    @FXML
    private Label initT1;

    @FXML
    private Label initT2;

    @FXML
    private Label totalSlContainer;

    @FXML
    private Label totalSalary;

    @FXML
    private Label sResult;

    @FXML
    private Label sResultText;

    @FXML
    private Label errorSearch;

    @FXML
    private Button toHomeBtn;

    @FXML
    private Button buy2;

    @FXML
    private TextField buy1;

    @FXML
    private TextField sell2;

    @FXML
    private TextField sell1;

    @FXML
    private Button sell3;

    @FXML
    private Label mList;




    @FXML
    void toHomePage(ActionEvent event) {
        init();
    }


    @FXML
    void searchCountry(ActionEvent event) {
        String s = (String) sCountry.getText();
        List<Player> playerList = Main.club.byCn(s);

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        errorSearch.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText(s + "'s players:");

        if(playerList.size() == 0) errorSearch.setText("No player(s) from " + s);
        else {
            errorSearch.setVisible(false);
            table2.setVisible(false);
            setTable(playerList);
        }

        sCountry.setText(null);
    }

    @FXML
    void searchMxAge(ActionEvent event) {
        List<Player> playerList = Main.club.mxClubAge();


        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        errorSearch.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("Players with max Age");

        setTable(playerList);
    }

    @FXML
    void searchMxHeight(ActionEvent event) {
        List<Player> playerList = Main.club.mxClubHeight();

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        errorSearch.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("Players with max Height");

        setTable(playerList);

    }

    @FXML
    void searchMxSalary(ActionEvent event) {
        List<Player> playerList = Main.club.mxClubSalary();

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        errorSearch.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("Players with max Salary");

        setTable(playerList);

    }

    @FXML
    void searchName(ActionEvent event) {
        String pName = (String) sName.getText();
        sName.setText(null);
        Player p = Main.club.byName(pName);

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        errorSearch.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);


        if(p == null) sResultText.setText("No player with such name found!");
        else {
            sResultText.setText("player-> " + p.getName());
            List<Player> playerList = new ArrayList<>();
            playerList.add(p);
            setTable(playerList);
        }


    }

    @FXML
    void searchPosition(ActionEvent event) {
        String s = (String) sPosition.getText();

        List<Player> playerList = Main.club.byPosition(s);

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);

        errorSearch.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);


        if(playerList.size() == 0) {
            if(s.equalsIgnoreCase("defender") || s.equalsIgnoreCase("forward") ||
                    s.equalsIgnoreCase("midfielder") || s.equalsIgnoreCase("goalkeeper")) {
                errorSearch.setVisible(false);
                sResultText.setText("No player in " + s + " position");
            } else {
                errorSearch.setText("Invalid position of player(s)");
                sResultText.setText("Invalid");
            }
        } else {
            sResultText.setText(s + "(s)");
            setTable(playerList);
        }
        sPosition.setText(null);
    }

    @FXML
    void searchSalary(ActionEvent event) {
        String s1 = (String) sLow.getText();
        String s2 = (String) sHigh.getText();

        double l = 0, h = 0;



        try {
            l = (double) Double.parseDouble(s1);
            h = (double) Double.parseDouble(s2);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Input");
            alert.setHeaderText("Incorrect salary range");
            alert.setContentText("The salary ranges you input are not double.");
            alert.showAndWait();
            return;
        }

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);

        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);
        errorSearch.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("salary range(" + l + "$  -  " + h + "$)" );

        if(l > h) {
            errorSearch.setText("Low salary must be less than high salary");
            return;
        }



        List<Player> playerList = Main.club.bySalary(l, h);

        if(playerList.size() == 0) errorSearch.setText("No player found on this range!");
        else {
            errorSearch.setVisible(false);
            setTable(playerList);
        }

        sLow.setText(null);
        sHigh.setText(null);

    }

    @FXML
    void totalSalary(ActionEvent event) {
        double total = Main.club.getTotalSalary();
        //String s = Double.toString(total);

        //Setting the visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        errorSearch.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);
        sell1.setVisible(false);
        sell2.setVisible(false);
        sell3.setVisible(false);

        totalSalary.setVisible(true);
        totalSlContainer.setVisible(true);
        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("total yearly salary of the club");

        DecimalFormat decimalFormatter = new DecimalFormat("###################.##");
        totalSalary.setText(decimalFormatter.format(total )+ " $");

    }

    @FXML
    void CnWiseCount(ActionEvent event) {

        HashMap<String, Integer> mapCountPlayer = Main.club.playerCountCn();

        List<CnCount> cnCountList = new ArrayList<>();

        mapCountPlayer.forEach((key, value) ->
                cnCountList.add(new CnCount(key, value)));

        t2countryName.setCellValueFactory(new PropertyValueFactory<CnCount, String>("country"));
        t2PlayersCount.setCellValueFactory(new PropertyValueFactory<CnCount, Integer>("count"));

        //Setting the visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        errorSearch.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);
        sell1.setVisible(false);
        sell2.setVisible(false);
        sell3.setVisible(false);

        toHomeBtn.setVisible(true);
        sResult.setVisible(true);
        sResultText.setVisible(true);

        sResultText.setText("country wise player count");

        setTableCnCount(cnCountList);


    }


    @FXML
    void logout(ActionEvent event) {
        try {

            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void init() {

        //Setting the visibility
        table.setVisible(false);
        table2.setVisible(false);
        marketTable.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        sResult.setVisible(false);
        sResultText.setVisible(false);
        errorSearch.setVisible(false);
        toHomeBtn.setVisible(false);
        buy2.setVisible(false);
        buy1.setVisible(false);
        mList.setVisible(false);


        initT1.setVisible(true);
        initT2.setVisible(true);
        sell1.setVisible(true);
        sell2.setVisible(true);
        sell3.setVisible(true);

        //Setting initial Levels
        name.setText(Main.club.getName());
        initT1.setText("Total Players: " + Main.club.getPlayerList().size());
        DecimalFormat decimalFormatter = new DecimalFormat("###################.##");
        initT2.setText("Total Yearly Salary: " + decimalFormatter.format(Main.club.getTotalSalary()) + " $");


        //Setting the main Table
        tName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        tPos.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        tNum.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
        tAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
        tCn.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
        tHeight.setCellValueFactory(new PropertyValueFactory<Player, Double>("height"));
        tSalary.setCellValueFactory(new PropertyValueFactory<Player, Double>("salary"));


        List<Player> playerList = Main.club.getPlayerList();
        setTable(playerList);

        //Setting the market Table
        mName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        mPos.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        mCountry.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
        mAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
        mCLub.setCellValueFactory(new PropertyValueFactory<Player, String>("club"));
        mPrice.setCellValueFactory(new PropertyValueFactory<Player, Double>("price"));

    }

    @FXML
    void showMarket(ActionEvent event) {

        //Setting Visibility
        table.setVisible(false);
        table2.setVisible(false);
        totalSalary.setVisible(false);
        totalSlContainer.setVisible(false);
        initT1.setVisible(false);
        initT2.setVisible(false);
        sResult.setVisible(false);
        sResultText.setVisible(false);
        errorSearch.setVisible(false);
        sell1.setVisible(false);
        sell2.setVisible(false);
        sell3.setVisible(false);


        toHomeBtn.setVisible(true);
        mList.setVisible(true);
        buy1.setVisible(true);
        buy2.setVisible(true);

        List<Player> marketList = new ArrayList<>();

        if(Main.marketList.size() != 0) {
            marketList = Main.marketList;
        }


        setMarketTable(marketList);

    }



    public void setTable(List<Player> players) {
        list = FXCollections.observableList(players);

        //Setting the visibility
        table.setVisible(true);
        errorSearch.setVisible(false);

        table.setItems(list);
    }

    public void setTableCnCount(List<CnCount> cnCounts) {
        listCnCount = FXCollections.observableList(cnCounts);

        //Setting the visibility
        table2.setVisible(true);
        errorSearch.setVisible(false);

        table2.setItems(listCnCount);
    }


    public void setMarketTable(List<Player> players) {
        listMarket = FXCollections.observableList(players);

        //Setting the visibility
        marketTable.setVisible(true);
        errorSearch.setVisible(false);

        marketTable.setItems(listMarket);
    }



    @FXML
    void sellPlayer(ActionEvent event) throws IOException {

        String sName = (String) sell1.getText();
        String s2 = (String) sell2.getText();

        sell1.setText(null);
        sell2.setText(null);

        double sPrice = 0;

        try {
            sPrice = (double) Double.parseDouble(s2);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Input");
            alert.setHeaderText("Incorrect price");
            alert.setContentText("The price you set is not double");
            alert.showAndWait();
            return;
        }

        if(Main.club.existPlayer(sName)) {
            Player sP = Main.club.byName(sName);

            if(sP.isSellStatus()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Sold!");
                alert.setHeaderText("Player is already sold");
                alert.setContentText("Player is already on the market");
                alert.showAndWait();
                return;
            }

            sP.setPrice(sPrice);
            sP.setSellStatus(true);


            transferPlayer tp = new transferPlayer(sP);
            tp.settStatus(1); //1 means sell
            tp.setcName(sP.getClub());


            main.getNetworkUtil().write(tp);

        } else  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No such Player");
            alert.setHeaderText("Incorrect player Name");
            alert.setContentText("There is no player with the input name");
            alert.showAndWait();
            return;
        }


    }

    @FXML
    void buyPlayer(ActionEvent event) throws IOException {


        String bName = (String)buy1.getText();
        Player bP = null;

        boolean check = true;

        for (Player p: Main.marketList) {
            if(p.getName().equalsIgnoreCase(bName)) {
                p.setSellStatus(false);
                check = false;
                bP = p;

                break;
            }
        }

        if(check) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No such Player");
            alert.setHeaderText("Incorrect player Name");
            alert.setContentText("There is no player with the input name");
            alert.showAndWait();
            buy1.setText(null);
            return;
        }

        transferPlayer tp2 = new transferPlayer(bP);
        tp2.settStatus(2); //2 means buy
        tp2.setcName(main.getClientName());
        main.getNetworkUtil().write(tp2);
    }

}
