package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.List;

public class Sample {
    protected final Service currentService;
    private final String path;
    public Sample(String path){
        currentService = new Service();
        this.path = path;
    }

    public void upload() {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String toyId = reader.readLine();
            while (toyId != null) {
                String name = reader.readLine();
                String weight = reader.readLine();
                this.currentService.putToy(new Toy(Integer.parseInt(toyId), name, Integer.parseInt(weight)));
                toyId = reader.readLine();
            }
            reader.close();
            fileReader.close();

        } catch (IOException e) {
        System.out.println("Создайте файл" + path);
        e.printStackTrace();
        }
    }

    public void save(){
        try(FileWriter writer = new FileWriter(path, false)) {
            for (int i=0; i < currentService.count(); i++){
                Toy toy = currentService.getToy(i);
                writer.append(String.format("%s\n", toy.getId()));
                writer.append(String.format("%s\n", toy.getName()));
                writer.append(String.format("%s\n", toy.getWeight()));
            }
            writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public Service currentService(){
        return this.currentService;
    }
    public void saveResult(String pathRes, List<Toy> toyList){
        try (FileWriter writer = new FileWriter(pathRes, false)){
            for (Toy toy : toyList){
                writer.append(String.format("%s ", toy.getId()));
                writer.append(String.format("%s ", toy.getName()));
                writer.append(String.format("%s ", toy.getWeight()));
                writer.append("\n ");
                writer.flush();

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

 }
