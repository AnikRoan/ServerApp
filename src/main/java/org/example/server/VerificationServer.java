package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VerificationServer {
    private static String password = "пиріг";
    private static String client = "Кліент: ";
    private static int port = 8081;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss\n");

    public static void main(String[] args) throws IOException {
        boolean exit = true;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println(ServerStrings.START_MESSAGE.getInfo());


        while (exit) {
            try {

                serverSocket.setSoTimeout(30000);

                Socket clientSocket = serverSocket.accept();

                System.out.println(ServerStrings.CONNECT_MESSAGE.getInfo());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream();

                System.out.println(ServerStrings.SERVER_NAME.getInfo() + ServerStrings.HELLO_SERVER.getInfo());
                out.write(ServerStrings.HELLO_SERVER.getInfo().getBytes());


                System.out.println(client + in.readLine());

                System.out.println(ServerStrings.SERVER_NAME.getInfo() + ServerStrings.QUESTION.getInfo());
                out.write(ServerStrings.QUESTION.getInfo().getBytes());

                String answer = in.readLine();
                System.out.println(client + answer);
                if (answer.equalsIgnoreCase(password)) {

                    System.out.println(ServerStrings.SERVER_NAME.getInfo() + dataTimeInfo());

                    out.write(((dataTimeInfo()).getBytes()));

                    System.out.println(client + in.readLine());

                    System.out.println(ServerStrings.SERVER_NAME.getInfo() + ServerStrings.GOOD_BYE.getInfo());
                    out.write(ServerStrings.GOOD_BYE.getInfo().getBytes());

                    System.out.println(ServerStrings.SEARCH_CONNECTION.getInfo());


                } else {

                    out.write(ServerStrings.INCORRECT_UNSWER.getInfo().getBytes());
                    in.readLine();

                    System.out.println(ServerStrings.SERVER_NAME.getInfo() + ServerStrings.BOMB.getInfo());
                    out.write(ServerStrings.BOMB.getInfo().getBytes());

                    System.out.println(ServerStrings.SEARCH_CONNECTION.getInfo());


                }


            } catch (SocketTimeoutException e) {
                serverSocket.close();
                System.out.println(ServerStrings.OFF_SERVER.getInfo());
                exit = false;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static String dataTimeInfo() {

        LocalDateTime currentDateTime = LocalDateTime.now();

        return currentDateTime.format(formatter);


    }

}



























