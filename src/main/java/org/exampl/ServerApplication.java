package org.exampl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServerApplication {


    public static void main(String[] args)  {
        try {
        ServerSocket serverSocket = new ServerSocket(8081);

        System.out.println(ServerInfo.START_INFO.getInfo());

            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println(ServerInfo.CONNECT_MESSAGE.getInfo());

            out.write(ServerInfo.GREETING.getInfo());
            out.flush();

              String clientGreeting = in.readLine();
            if (clientGreeting.matches(".*[А-ЩЬЮЯҐЄІЇа-щьюяґєії].*") && (clientGreeting.length() < 6)) {
                out.write(ServerInfo.SECURITY_QUESTION.getInfo());
                out.flush();

                if (!in.readLine().equalsIgnoreCase(ServerInfo.CORRECT_ANSWER.getInfo())) {
                    out.write(ServerInfo.INCORRECT_ANSWER_INFO.getInfo() + ServerInfo.BOMB.getInfo());


                } else {
                    out.write(dataTimeInfo() + "\n");
                }
                out.flush();
                socket.close();

            } else {
                out.write(ServerInfo.COURTESY.getInfo());
                out.flush();
                System.out.println(in.readLine());
                socket.close();


            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    private static String dataTimeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(formatter);


    }


}
