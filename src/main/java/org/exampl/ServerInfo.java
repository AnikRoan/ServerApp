package org.exampl;

public enum ServerInfo {

     COURTESY("Сподіваюсь у вас все добре, до побачення\n"),
    START_INFO("Сервер запущено"),
    CONNECT_MESSAGE("Кліент підключився"),
    GREETING("Вітаю\n"),
    SECURITY_QUESTION("Що таке паляниця? \n"),
    CORRECT_ANSWER("пиріг"),

    BOMB("\uD83D\uDCA3\n"),

    INCORRECT_ANSWER_INFO("Відповідь не вірна\n");



    private final String info;



    ServerInfo(String info) {
        this.info = info;
    }
    public String getInfo(){
        return info;
    }

}
