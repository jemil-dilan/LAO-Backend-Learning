package org.Exercise3;

import org.Exercise7.Product;

import java.util.*;

public class GestionaireTaches {
    List<Tache> taches;

    public GestionaireTaches() {
        this.taches = new ArrayList<>();
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void addTask(Tache tache) {
        taches.add(tache);
    }

    public void deleteTask(String description) {
        taches.removeIf(tache -> Objects.equals(tache.getDescription(), description));
    }

    public void markTaskAsFinished(String description) {
        for (Tache tache : taches){
            if (Objects.equals(tache.getDescription(), description)){
                tache.setStatus(Status.TERMINER);
            }
        }
    }

    public Status getTaskStatusByDescription(String description){
        for (Tache tache : taches){
            if (Objects.equals(tache.getDescription(), description)){
                return tache.getStatus();
            }
        }
        throw new RuntimeException("Tache introuvable");
    }

    public Optional<Tache> findTaskById(String description){
        return taches.stream()
                .filter(tache -> Objects.equals(tache.getDescription(), description))
                .findFirst();
    }

    public Tache modifyTaskDescription(String description, String newDescription){
        for (Tache tache : taches){
            if (Objects.equals(tache.getDescription(), description)){
                tache.setDescription(newDescription);
                return tache;
            }
        }
        return null;
    }
}
