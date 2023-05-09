package Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
    private String name;
    private List<Player> players;
    private int playersCount;

    public Country(){
        playersCount = 0;
        players = new ArrayList();
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPlayerCount(){
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }


    public void addPlayer(Player p){
        players.add(p);
        playersCount++;
    }

}
