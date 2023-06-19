package org.example;

public class Toy {
    public int id;
    public String name;
    public int weight;
    public Toy (int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Идентификатор игрушки: " + id + "; Имя: " + name + "; Вес: " + weight;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
