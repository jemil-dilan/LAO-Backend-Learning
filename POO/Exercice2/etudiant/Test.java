package etudiant;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        
        List <Integer> notes = new ArrayList <Integer> ();

        notes.add(42);
        notes.add(2);
        notes.add(265);

        Etudiant etudiant = new Etudiant("Blacky",0, notes);

        etudiant.mention();
        System.out.println("Notes de l'étudiant " + etudiant.getNom() +
                            "\nMeilleure note " + etudiant.getMeilleureNote() +
                            "\nPire note " + etudiant.getPlusBasseNote());

        System.out.println(notes);

    }
}
