package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Presenter {
   private final View view;
   private final Sample sample;

   public Presenter(View view, String path) {
      this.view = view;
      sample = new Sample(path);
   }

   public void showAll() {
      if (sample.currentService.getToys().size() == 0)
         view.emptyListMessage();
      else
         view.showAll(sample.currentService.getToys());
   }

   public void deleteToy() {
      if (sample.currentService.getToys().size() == 0)
         view.emptyListMessage();
      else
         sample.currentService().remove(view.getToyId());
   }

   public void putToy() {
      if (sample.currentService().putToy(new Toy(view.getToyId(), view.getToyNaming(), view.getToyWeight())))
         view.saveItem();
      else
         view.saveError();
   }

   public void saveToFile() {
      sample.save();
      view.saveAll();
   }

   public void clearAll() {
      if(sample.currentService.getToys().size() == 0)
         view.emptyListMessage();
      else{
         if(view.allDecision()){
            sample.currentService().getToys().clear();
            System.out.println("Все записи очищены");
         }
      }
   }

   public void loadAllFile() {
      sample.upload();
      view.uploadMessage();
   }

   public void practicalJokes() {
      PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
      Toy droppedToy;
      List<Toy> droppedToys = new ArrayList<>();
      if(sample.currentService.getToys().size() != 0){
         int times = view.getPracticalJokes();
         priorityQueue.addAll(sample.currentService().getToys());
         while (priorityQueue.size() < times) {
            priorityQueue.addAll(sample.currentService().getToys());
         }
         for (int i = 0; i < times; i++) {
            droppedToy = priorityQueue.remove();
            view.showGetToy(droppedToy);
            droppedToys.add(droppedToy);
         }
         sample.saveResult(Result.pathRes, droppedToys);
      } else
         view.emptyListMessage();
   }
}
