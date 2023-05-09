package Collections;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuySell implements Serializable {
    private Club club;
    private List<Player> sellList;

    public BuySell() {
        club = new Club();
        sellList = new ArrayList<>();
    }

    public BuySell( Club club, List<Player> sellList) {

        this.club = club;
        this.sellList = sellList;
    }

    public List<Player> getSellList() {
        return sellList;
    }

    public void setSellList(List<Player> sellList) {
        this.sellList = sellList;
    }

    public void setClub(Club club) {
        this.club = club;
    }


    public Club getClub() {
        return club;
    }


}
