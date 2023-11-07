package org.example;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class UkrainianClient implements Client {

    private static Socket ukrSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static final String startHello = "привіт\n";
    private static final String paswordWord = "пиріг\n";
    private static final String goodBye = "дякую допобачення\n";


    @Override
    public void startSocket(String host, int port) {
        try {
            try {
                ukrSocket = new Socket(host, port);
                in = new BufferedReader(new InputStreamReader(ukrSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(ukrSocket.getOutputStream()));



                System.out.println("Сервер: " + in.readLine());
                System.out.println(startHello);
                out.write(startHello);
                out.flush();


                System.out.println("Сервер: " + in.readLine());

                System.out.println(paswordWord);
                out.write(paswordWord);
                out.flush();


                System.out.println("Сервер: " + in.readLine());

                System.out.println(goodBye);
                out.write(goodBye);
                out.flush();


                System.out.println("Сервер: " + in.readLine());


            } catch (SocketException у) {
                System.out.println("Сервер off");

            } finally {

                ukrSocket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            System.out.println(" client cloys");
        }


    }

}
