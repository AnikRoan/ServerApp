package org.exampl;

public enum ServerInfo {
    CLIENT("Client: "),
    SERVER_NAME("Server: "),
    START_MESSAGE("the server started..."),
    CONNECT_MESSAGE("client connected."),
    HELLO_SERVER("hello enter your greeting: \n"),
    QUESTION("Що таке паляниця? \n"),
    GOOD_BYE("Goodbye\n"),
    BOMB("\uD83D\uDCA3\n"),
    SEARCH_CONNECTION("search for connection..."),
    INCORRECT_UNSWER("incorrect unswer...\n"),
    OFF_SERVER("no connections...");

    private final String info;



    ServerInfo(String info) {
        this.info = info;
    }
    public String getInfo(){
        return info;
    }

}
