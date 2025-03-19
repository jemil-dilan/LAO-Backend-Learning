package org.Exercise3;

import java.util.Objects;

public class Tache {
    private String description;
    private Status status;
    private int priorite;

    public Tache(String description, Status status) {
        this.description = description;
        this.status = status;

        switch (status) {
            case EN_COURS -> priorite = 5;
            case ANNULER-> priorite = 3;
            case TERMINER -> priorite = 0;
            case null, default -> System.out.println("Etat invalide");
        }
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getPriorite() {
        return priorite;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return getPriorite() == tache.getPriorite() && Objects.equals(getDescription(), tache.getDescription()) && Objects.equals(getStatus(), tache.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getStatus(), getPriorite());
    }

    @Override
    public String toString() {
        return "description='" + description + '\'' +
                ", status=" + status.getDescription() +
                ", priorite=" + priorite ;
    }
}

