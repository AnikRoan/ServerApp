package org.exampl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerApplication {
    public static void main(String[] args) {

    }

    private static String dataTimeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss\n");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(formatter);


    }

}
