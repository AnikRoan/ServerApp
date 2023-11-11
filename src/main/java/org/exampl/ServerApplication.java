package org.exampl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerApplication {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);

        System.out.println(ServerInfo.START_INFO.getInfo());

        try(Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            System.out.println(ServerInfo.CONNECT_MESSAGE.getInfo());

            out.write(ServerInfo.GREETING.getInfo());

            if(!in.readLine().matches(".*[А-ЩЬЮЯа-щьюяЇїІіЄєҐґ].*")){
                out.write(ServerInfo.SECURITY_QUESTION.getInfo());
                if(!in.readLine().equalsIgnoreCase(ServerInfo.CORRECT_ANSWER.getInfo())){
                    out.write(ServerInfo.INCORRECT_ANSWER_INFO.getInfo()+ServerInfo.BOMB.getInfo());

                }else{
                    out.write(dataTimeInfo().getBytes());
                }
            }

        }



    }

    private static String dataTimeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss\n");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(formatter);


    }

}
