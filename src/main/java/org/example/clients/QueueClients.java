package org.example.clients;

import java.util.ArrayList;
import java.util.List;

public class QueueClients {
    private final static String host = "localhost";
    private final static int port = 8081;
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new MoscalClient());
        clients.add(new UkrainianClient());

        for(Client client:clients){
            client.startSocket(host,port);
        }



    }
}
