package org.example;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private final List<Toy> toys;
    public Service() {
        this.toys = new ArrayList<>();
    }
    public boolean putToy(Toy toy){
        boolean flag = false;
        if (!toys.contains(toy)){
            this.toys.add(toy);
            flag = true;
        }
        return flag;
    }
    public Toy getToy(int index){
        return toys.get(index);
    }
    public void remove(int toyId){
        if (indexContains(toyId) != -1){
            toys.remove(indexContains(toyId));
            System.out.println("Успешное удаление");
        } else
            System.out.println("Идентификатор не найден");
    }
    private int indexContains(int index){
        int searchIndex = -1;
        for (Toy toy : toys){
            if (toy.getId() == index)
                searchIndex = toys.indexOf(toy);
        }
        return searchIndex;
    }

    public List<Toy> getToys(){
        return toys;
    }

    public int count() {
        return toys.size();
    }


}
