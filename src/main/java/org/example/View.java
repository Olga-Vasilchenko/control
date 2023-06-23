package org.example;
import java.util.List;
import org.example.Toy;

public interface View {
    int getToyId();
    String getToyNaming();
    int getToyWeight();
    void showAll(List<Toy> toys);
    void saveAll();
    void saveError();
    void saveItem();
    boolean allDecision();
    void emptyListMessage();
    void uploadMessage();
    int getPracticalJokes();
    void showGetToy(Toy toy);
}
