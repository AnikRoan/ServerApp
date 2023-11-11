package org.example.server;

public enum ServerStrings {
    SERVER_NAME("Сервер: "),
    START_MESSAGE("Сервер запущений. Очікування підключення..."),
    CONNECT_MESSAGE("Клієнт підключився."),
    HELLO_SERVER("Привіт, введіть ваше привітання: \n"),
    QUESTION("Що таке паляниця? \n"),
    GOOD_BYE("До побачення\n"),
    BOMB("\uD83D\uDCA3\n"),
    SEARCH_CONNECTION("пошук наступного підключення"),
    INCORRECT_UNSWER("Неправильна відповідь. Відключення...\n"),
    OFF_SERVER("Підключення відсутні. Сервер вимкненно");

    private final String info;



    ServerStrings(String info) {
        this.info = info;
    }
    public String getInfo(){
        return info;
    }
}
