package org.exampl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServerApplication {
    private final static int port = 8081;
    private final static int minWordLength = 6;
    private  final  static  String regexCheck =".*[А-ЩЬЮЯҐЄІЇа-щьюяґєії].*";
    private final static String dataTimeRegex = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            serverSocket.setSoTimeout(70000);

            System.out.println(ServerInfo.INFO_START.getInfo());

            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println(ServerInfo.CONNECT_MESSAGE.getInfo());

            out.write(ServerInfo.GREETING.getInfo());
            out.flush();

            String clientGreeting = in.readLine();

            if (clientGreeting.matches(regexCheck) || (clientGreeting.length() < minWordLength)) {
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
                out.write(ServerInfo.FAREWELL.getInfo());
                out.flush();
                System.out.println(in.readLine());
                socket.close();


            }
            serverSocket.close();
            in.close();
            out.close();
            socket.close();


        } catch (SocketTimeoutException e) {
            System.out.println("no connection..."+e.getMessage());


        }catch (IOException e){
            e.printStackTrace();

        }

    }


    private static String dataTimeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataTimeRegex);
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(formatter);


    }


}
