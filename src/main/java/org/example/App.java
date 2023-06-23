package org.example;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void buttonStart(){
        System.out.println("Добро пожаловать на розыгрыш игрушек!");
        Presenter presenter = new Presenter(new Console(), Result.path);
        presenter.loadAllFile();

        String command;
        while (true) {

            command = prompt("""
                            
                    1 - Показать все игрушки
                    2 - Удалить игрушку
                    3 - Добавить новую игрушку
                    4 - Сохранить изменения в файл
                    5 - Очистить все записи
                    6 - Загрузить все записи
                    7 - Провести розыгрыш
                    8 - Выйти
                    Выберите:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command){

                    case "1" -> presenter.showAll();
                    case "2" -> presenter.deleteToy();
                    case "3" -> presenter.putToy();
                    case "4" -> presenter.saveToFile();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.loadAllFile();
                    case "7" -> presenter.practicalJokes();
                    default -> System.out.println("\n Команда не найдена");
                }
            } catch (Exception e) {
                System.out.println("Ошибка " + e.getMessage());
            }
        }
    }
    private static String prompt (String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("Идентификатор игрушки: "));
        String name = prompt("Название игрушки: ");
        String weight = prompt("Вес игрушки: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }

}
