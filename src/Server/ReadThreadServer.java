package Server;

import Collections.*;
import Util.LoginDTO;
import Util.NetworkUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, NetworkUtil> clientMap;
    public HashMap<String, String> clubLoginMap;


    public ReadThreadServer(HashMap<String, NetworkUtil> map,HashMap<String, String> clubLoginMap, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.clubLoginMap = clubLoginMap;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();

                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        String password = clubLoginMap.get(loginDTO.getUserName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));




                        if(loginDTO.isStatus()) {
                            clientMap.put(loginDTO.getUserName(), this.networkUtil);
                            Server.clientNameList.add(loginDTO.getUserName());
                        }

                        Club club = Server.getCollection().getCLub(loginDTO.getUserName());
                        ClientClub clientClub = new ClientClub(loginDTO, club, Server.getCollection().getSellList());
                        networkUtil.write(clientClub);

                    }

                    if (o instanceof transferPlayer) {
                        transferPlayer tp = (transferPlayer) o;

                        Player player = tp.getPlayer();


                        List<Player> sellList = Server.getCollection().getSellList();

                        if(tp.gettStatus() == 1) {

                            for (Player p: Server.getCollection().getPlayerList()) {
                                if(player.getName().equalsIgnoreCase(p.getName())) {
                                    p.setSellStatus(true);
                                }
                            }

                            player.setSellStatus(true);
                            sellList.add(player);





                            for(String s: Server.clientNameList) {
                                Club club = Server.getCollection().getCLub(s);
                                BuySell buySell= new BuySell(club, Server.getCollection().getSellList());
                                clientMap.get(s).write(buySell);
                            }

                        } else  if(tp.gettStatus() == 2) {



                            int x = 0;
                            for (Player p: sellList) {
                                if(p.getName().equalsIgnoreCase(player.getName())) {
                                    break;
                                }
                                x++;
                            }

                            sellList.remove(x);


                            for (Player p: Server.getCollection().getPlayerList()) {
                                if(player.getName().equalsIgnoreCase(p.getName())) {
                                    Club sellingOne = Server.getCollection().getCLub(p.getClub());
                                    Club buyingOne = Server.getCollection().getCLub(tp.getcName());


                                    p.setClub(tp.getcName());


                                    int cn1 = 0;
                                    for(Player p1: sellingOne.getPlayerList()) {
                                        if(p1.getName().equalsIgnoreCase(player.getName())) {
                                            break;
                                        }
                                        cn1++;
                                    }

                                    sellingOne.getPlayerList().remove(cn1);
                                    p.setSellStatus(false);
                                    buyingOne.getPlayerList().add(p);
                                }
                            }

                            for(String s: Server.clientNameList) {
                                Club club = Server.getCollection().getCLub(s);
                                BuySell buySell= new BuySell(club, Server.getCollection().getSellList());
                                clientMap.get(s).write(buySell);
                            }
                        }
                    }
                }


            }
        } catch (Exception e) {
            System.out.println("Server " + e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



