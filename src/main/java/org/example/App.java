package org.example;

import java.util.Scanner;

public class App {
    public static void buttonStart(){
        Presenter presenter = new Presenter();

        String command;
        while (true) {

            command = prompt("""
                            
                    1 - Добавить игрушку
                    2 - Удалить игрушку
                    3 - Показать все игрушки
                    4 - Сохранить все записи в файл
                    5 - Очистить все записи
                    6 - Загрузить все записи из файла
                    7 - Сколько раз провести розыгрыш?
                    8 - Выйти
                    Выберите:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command){

                    case "1" - presenter.
                }
            }

        }
    }
    private static String prompt (String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
