package Collections;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Collection {
    public static final String INPUT_FILE_NAME = "players.txt";
    public static final String OUTPUT_FILE_NAME = "players.txt";
    public static final  String SELL_FILE_NAME = "Market.txt";

    private  List<Player> playerList;
    private List <Club> clubs;
    private List <Country> countries;
    private List <Player> sellList;

    public Collection() throws Exception {
        playerList = new ArrayList<>();
        clubs = new ArrayList<>();
        countries = new ArrayList<>();
        sellList = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

        while(true) {
            String line = br.readLine();
            if(line == null) break;
            String[] tokens =  line.split(",");
            Player p = new Player(tokens[0].trim(),
                                  tokens[1].trim(),
                                  Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]),
                    tokens[4].trim(),
                    tokens[5].trim(),
                    Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7])
            );

            playerList.add(p);
            addPlayerToClub(p.getClub(), p);
            addPlayerToCountry(p.getCountry(), p);
        }
        br.close();

        BufferedReader brSell = new BufferedReader(new FileReader(SELL_FILE_NAME));

        while(true) {
            String line = brSell.readLine();
            if(line == null) break;
            String[] tokens =  line.split(",");
            Player p = new Player(tokens[0].trim(),
                    tokens[1].trim(),
                    Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]),
                    tokens[4].trim(),
                    tokens[5].trim(),
                    Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7])
            );

            p.setPrice(Double.parseDouble(tokens[8]));

            sellList.add(p);

        }
        brSell.close();

    }

    public void writeToFile() throws IOException {

        System.out.println("Saving......");

        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        for (Player p: playerList) {
            bw.write(p.getName()  + "," + p.getCountry() + "," + p.getAge()
                    + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getSalary());
            bw.write("\n");
        }
        bw.close();

        BufferedWriter bwSell = new BufferedWriter(new FileWriter(SELL_FILE_NAME));

        for (Player p: sellList) {
            bwSell.write(p.getName()  + "," + p.getCountry() + "," + p.getAge()
                    + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getSalary() + "," + p.getPrice());
            bwSell.write("\n");
        }
        bwSell.close();
    }


    private void addPlayerToClub(String clubName, Player p) {

        if(clubs.size() == 0 || !existClub(clubName)){
            Club club = new Club();
            club.setName(clubName);
            clubs.add(club);
            club.addPlayer(p);
        } else {
            for(Club club : clubs){
                if(club.getName().equalsIgnoreCase(clubName)){
                    club.addPlayer(p);
                }
            }
        }
    }

    private void addPlayerToCountry(String countryName, Player p) {
        if(countries.size() == 0 || !existCountry(countryName)){
            Country country = new Country();
            country.setName(countryName);
            countries.add(country);
            country.addPlayer(p);
        }  else {
            for(Country country : countries){
                if(country.getName().equalsIgnoreCase(countryName)){
                    country.addPlayer(p);
                }
            }
        }
    }

    private boolean existClub(String clubName) {
        for(Club club : clubs){
            if(club.getName().equalsIgnoreCase(clubName))
                return true;
        }
        return false;
    }

    private boolean existCountry(String countryName){
        for(Country country : countries){
            if(country.getName().equalsIgnoreCase(countryName))
                return true;
        }
        return false;
    }



    //Getters
    public Club getCLub(String name) {
        Club found = new Club();
        for(Club c: clubs) {
            if(c.getName().equalsIgnoreCase(name)) found = c;
        }
        return found;
    }

    public List<Club> getClubList() {
        return this.clubs;
    }

    public List<Player> getSellList() {
        return sellList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

}


