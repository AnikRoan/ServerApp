package org.example.clients;



public class MoscalClient extends Client {
    private static final String userName = "Московит: ";
    private static final String greetings = "привет\n";
    private static final String answer = "что что?\n";
    private static final String parting = "эй, что происходит\n";


    @Override
    public String getGreetings() {
        return greetings;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String getParting() {
        return parting;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void startSocket(String host, int port) {
        super.startSocket(host, port);
    }


}