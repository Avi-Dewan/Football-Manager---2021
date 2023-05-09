package Collections;

import java.io.Serializable;

public class transferPlayer implements Serializable {
    private Player player;
    private int tStatus;
    private String cName;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int gettStatus() {
        return tStatus;
    }

    public void settStatus(int tStatus) {
        this.tStatus = tStatus;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }



    public transferPlayer(Player player) {
        this.player = player;
    }



}
