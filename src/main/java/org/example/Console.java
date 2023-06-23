package org.example;

import java.util.List;
import java.util.Scanner;

public class Console implements View {
    Scanner in;
    public Console(){
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.println("Идентификатор игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.println("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.println("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("Показать все игрушки: ");
        for (Toy toy : toys){
            System.out.println(toy);
        }
    }

    @Override
    public void saveAll() {
        System.out.println("Все записи сохраняются в файл: " + Result.path);
    }

    @Override
    public void saveItem() {
        System.out.println("\nВсе записи добавлены");
    }

    @Override
    public void saveError() {
        System.out.println("\nНе удалось добавить");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("Список игрушек пуст");
    }

    @Override
    public boolean allDecision() {
        boolean f = false;
        System.out.println("\nВы хотите очистить все записи из файла? (да/нет): ");
        if ((in.nextLine().equalsIgnoreCase("да"))) {
            f = true;
        }
        return f;
    }

    @Override
    public void uploadMessage() {
        System.out.println("\nФайл загружен");
    }

    @Override
    public int getPracticalJokes() {
        System.out.println("Сколько раз вы хотите провести розыгрыш?: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультаты розыгрыша: ");
        System.out.println(toy);
    }

}
