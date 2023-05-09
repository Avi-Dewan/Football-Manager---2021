package Main;

import Collections.*;
import Util.LoginDTO;
import Util.NetworkUtil;
import javafx.application.Platform;

import java.io.IOException;
import java.util.List;

public class ReadThreadClient implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThreadClient(Main main) {
       this.main = main;
       this.thr = new Thread(this);
       thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();

                if(o!= null) {
                    if (o instanceof ClientClub) {
                        ClientClub clientClub = (ClientClub)o;

                        LoginDTO loginDTO = clientClub.getLoginDTO();
                        Club club = clientClub.getClub();
                        List <Player> sellList = clientClub.getSellList();

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (loginDTO.isStatus()) {
                                    try {
                                        Main.club.clear();
                                        Main.club.setName(club.getName());
                                        Main.club.setPlayers(club.getPlayerList());
                                        Main.club.setPlayersCount(club.getPlayersCount());


                                        main.setClientName(club.getName());


                                        Main.marketList.clear();

                                        for(Player p: sellList) {
                                            if(!Main.club.existPlayer(p.getName())) {
                                                Main.marketList.add(p);
                                            }
                                        }


                                        main.showMainPage();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    main.showAlert();
                                }

                            }
                        });
                    }

                    if (o instanceof BuySell) {
                        BuySell buySell = (BuySell) o;

                        Club club = buySell.getClub();
                        List <Player> sellList = buySell.getSellList();

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {

                                    try {
                                        Main.club.clear();
                                        Main.club.setName(club.getName());
                                        Main.club.setPlayers(club.getPlayerList());
                                        Main.club.setPlayersCount(club.getPlayersCount());



                                        Main.marketList.clear();
//                                        Main.marketList.addAll(sellList);

                                        for(Player p: sellList) {
                                            if(!Main.club.existPlayer(p.getName())) {
                                                Main.marketList.add(p);
                                            }
                                        }


                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }


                            }
                        });
                    }

                    }


                }

        }
         catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



