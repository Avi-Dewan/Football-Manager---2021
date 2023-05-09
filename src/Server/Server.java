package Server;

import Collections.*;
import Util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;
    public HashMap<String, String> clubLoginMap;

    public static List<String> clientNameList = new ArrayList<>();
    private static Collection collection;

    public static Collection getCollection() {
        return collection;
    }

    Server() {
        clientMap = new HashMap<>();

        clubLoginMap = new HashMap<>();

        clubLoginMap.put("Liverpool", "liv");
        clubLoginMap.put("Arsenal", "ars");
        clubLoginMap.put("Manchester United", "manU");
        clubLoginMap.put("Manchester City", "manC");
        clubLoginMap.put("Chelsea", "che");

        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(clientMap, clubLoginMap,  networkUtil);
    }

    public static void main(String args[]) throws Exception {
        collection = new Collection();
        Server server = new Server();

    }
}
