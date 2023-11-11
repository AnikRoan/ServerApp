package org.exampl;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        Socket client = new Socket("localhost", 8081);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            System.out.println(in.readLine());

        String message = scanner.next();
        while (!message.equals("exit")) {
            //message = scanner.next();
           out.write(message);
           out.flush();
            System.out.println(in.readLine());


        }


    }
}
