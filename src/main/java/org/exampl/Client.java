package org.exampl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        Socket client = new Socket("localhost",8081);
        OutputStream outputStream = client.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream,true);
        String message = scanner.next();
        while (!message.equals("exit")){
            message=scanner.next();
            printWriter.println(message);
            outputStream.write(message.getBytes());



        }


    }
}
