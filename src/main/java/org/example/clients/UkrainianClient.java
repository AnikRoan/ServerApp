package org.example.clients;



public class UkrainianClient extends Client {
    private static final String userName = "Українець: ";
    private static final String greetings = "привіт\n";
    private static final String answer = "пиріг\n";
    private static final String parting = "дякую допобачення\n";



    @Override
    public String getGreetings(){
        return greetings;
    }
    @Override
    public String getAnswer(){
        return answer;
    }
    @Override
    public String getParting(){
        return parting;
    }
    @Override
    public String getUserName(){
        return userName;
    }

    @Override
    public void startSocket(String host, int port) {
        super.startSocket(host, port);
    }


}
