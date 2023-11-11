package org.example.clients;

import org.example.server.ServerStrings;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public abstract class Client {
    private static Socket Socket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public abstract String getGreetings();
    public abstract String getAnswer();
    public abstract String getParting();
    public abstract String getUserName();



    public void startSocket(String host, int port) {

        try {
            try {
                Socket = new Socket(host, port);
                in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(Socket.getOutputStream()));


                System.out.println(ServerStrings.SERVER_NAME.getInfo() + in.readLine());
                System.out.println(getUserName() + getGreetings());
                out.write(getGreetings());
                out.flush();


                System.out.println(ServerStrings.SERVER_NAME.getInfo() + in.readLine());

                System.out.println(getUserName() + getAnswer());
                out.write(getAnswer());
                out.flush();


                System.out.println(ServerStrings.SERVER_NAME.getInfo() + in.readLine());

                System.out.println(getUserName() + getParting());
                out.write(getParting());
                out.flush();


                System.out.println(ServerStrings.SERVER_NAME.getInfo() + in.readLine());


            } catch (SocketException e) {
                System.out.println("Сервер off");

            } finally {

                Socket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            System.out.println("Сервер off");
        }


    }

}



