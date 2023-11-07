package org.example;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class MoscalClient implements Client{
    private static final String userName = "Московит: ";



    private static Socket ruSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static final String startHello = "привет\n";
    private static final String paswordWord = "что что?\n";
    private static final String goodBye = "эй, что происходит\n";



    @Override
    public void startSocket(String host, int port) {
        try {
            try {
                ruSocket = new Socket(host,port);
                in = new BufferedReader(new InputStreamReader(ruSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(ruSocket.getOutputStream()));



                System.out.println("Сервер: " + in.readLine());

                System.out.println(userName + startHello);
                out.write(startHello);
                out.flush();


                System.out.println("Сервер: " + in.readLine());


                System.out.println(userName + paswordWord);
                out.write(paswordWord);
                out.flush();


                System.out.println("Сервер: " + in.readLine());

                System.out.println(userName + goodBye);
                out.write(goodBye);
                out.flush();


                System.out.println("Сервер: " + in.readLine());

                ruSocket.close();
                in.close();
                out.close();


            } catch (SocketException у) {
                System.out.println("Сервер off");

            }

        } catch (IOException e) {
            System.out.println(" client cloys");
        }


    }
}