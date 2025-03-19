package org.Exercise3;

public enum Status{
    EN_COURS("en cours"),
    ANNULER("annuler"),
    TERMINER("terminer");

    private String description;

    Status(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
