package Collections;

import Util.LoginDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientClub implements Serializable {
    private Club club;
    private LoginDTO loginDTO;
    private List<Player> sellList;

    public ClientClub() {
        club = new Club();
        sellList = new ArrayList<>();
        loginDTO = new LoginDTO();
    }

    public ClientClub(LoginDTO loginDTO, Club club, List<Player> sellList) {
        this.loginDTO = loginDTO;
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

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public Club getClub() {
        return club;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }
}
