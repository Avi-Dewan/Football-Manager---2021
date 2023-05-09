package Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Club implements Serializable {
    private String name;
    private List<Player> players;
    private int playersCount;

    public Club() {
        name = "";
        playersCount = 0;
        players = new ArrayList();
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayerList() {
        return this.players;
    }

    public void addPlayer(Player player) {
            players.add(player);
            playersCount++;
    }

    public void showPlayers() {

        for(Player p: players) {
            System.out.println(p.getName());
        }
    }
    public List<Player> mxClubSalary() {

        List<Player> returnList = new ArrayList();

        double mxSalary = 0;


        for(Player p: players) {
            if(p.getSalary() > mxSalary) mxSalary = p.getSalary();
        }

        for (Player p: players) {
            if(p.getSalary() == mxSalary) {
                returnList.add(p);
            }
        }


        return returnList;
    }


    public List<Player> mxClubAge() {

        List<Player> returnList = new ArrayList();

        double mxAge = 0;

        for (Player p: players) {
            if(p.getAge() > mxAge) mxAge = p.getAge();
        }

        for (Player p: players) {
            if(p.getAge() == mxAge) returnList.add(p);
        }

        return returnList;
    }

    public List<Player> mxClubHeight() {

        List<Player> returnList = new ArrayList();

        double mxHeight = 0;


        for (Player p: players) {
            if(p.getHeight() > mxHeight) mxHeight = p.getHeight();
        }

        for (Player p: players) {
            if(p.getHeight() == mxHeight) returnList.add(p);
        }

        return returnList;
    }

    public double getTotalSalary() {
        double total = 0;


        for(Player p: players) {
            total += p.getSalary()*52.0;
        }

        return total;
    }

    public Player byName(String name) {

        Player player = null;


        for (Player p: players) {
            if(p.getName().equalsIgnoreCase(name)) {
                player = p;
                break;
            }
        }

        return player;
    }

    public List<Player> byCn(String country) {

        List<Player> returnList = new ArrayList();


        for (Player p: players) {
            if(p.getCountry().equalsIgnoreCase(country)){
                returnList.add(p);
            }
        }

        return returnList;
    }

    public List<Player> byPosition(String position) {
        List<Player> returnList = new ArrayList();



        for (Player p: players) {
            if(p.getPosition().equalsIgnoreCase(position)){
                returnList.add(p);
            }
        }



        return returnList;
    }


    public List<Player> bySalary(double l, double h) {
        List<Player> returnList = new ArrayList();

        for (Player p: players) {
            if(p.getSalary() >= l && p.getSalary() <= h) {
                returnList.add(p);
            }
        }

        return returnList;
    }

    public HashMap<String, Integer> playerCountCn() {

        HashMap<String, Integer> mapCountPlayer = new HashMap<String, Integer>();


        for(Player p: players){
            if(mapCountPlayer.containsKey(p.getCountry())){
                mapCountPlayer.put(p.getCountry(), mapCountPlayer.get(p.getCountry()) + 1);
            } else {
                mapCountPlayer.put(p.getCountry(), 1);
            }
        }

        return mapCountPlayer;
    }

    //new Added
    public void clear() {
        this.name = null;
        this.players.clear();
        this.playersCount = 0;
    }

    public void setPlayers(List<Player> players) {
        this.players.addAll(players);
    }

    public boolean existPlayer(String name) {
        for(Player p: players) {
            if(p.getName().equalsIgnoreCase(name)) return true;
        }

        return false;
    }

}
