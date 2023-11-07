package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VerificationServer {
    private static final String startMessage = "Сервер запущений. Очікування підключення...";
    private static final String connect = "Клієнт підключився.";
    private static final String serverask = "Привіт, введіть ваше привітання: \n";
    private static final String question = "Що таке паляниця? \n";
    private static final int port = 8081;
    private static final String bomb = "\uD83D\uDCA3\n";
    private static final String goodbye = "До побачення\n";


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println(startMessage);

        boolean exit = true;

        while (exit) {
            try {

                serverSocket.setSoTimeout(30000);

                Socket clientSocket = serverSocket.accept();

                System.out.println(connect);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream();

                System.out.println("Сервер: " + serverask);
                out.write(serverask.getBytes());



                System.out.println("Кліент: " + in.readLine());

                System.out.println("Сервер: " + question);
                out.write(question.getBytes());

                String anser = in.readLine();
                System.out.println("Кліент: " +anser);
                if (anser.equalsIgnoreCase("пиріг")) {


                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss\n");
                    String formattedDateTime = currentDateTime.format(formatter);

                    System.out.println("Сервер: " + formattedDateTime);
                    out.write(((formattedDateTime).getBytes()));

                    System.out.println("Кліент:" + in.readLine());

                    System.out.println("Сервер: " + goodbye);
                    out.write(goodbye.getBytes());

                    System.out.println("пошук наступного підключення");


                } else {

                    out.write("Неправильна відповідь. Відключення...\n".getBytes());
                    in.readLine();

                    System.out.println("Сервер: " + bomb);
                    out.write(bomb.getBytes());

                    System.out.println("Пошук наступного підключення...");


                }


            } catch (SocketTimeoutException e) {
                serverSocket.close();
                System.out.println("Підключення відсутні. Сервер вимкненно");
                exit = false;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}



























