package etudiant;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {

    private String nom;
    private int numeroEtudiant;
    private List<Integer> notes = new ArrayList<Integer>();

    public String getNom() {
        return nom;
    }

    public void ajouterNotes(Integer note){
        if (note >= 0 && note <= 100) {
            
            notes.add(note);
        } else {
            System.out.println("Entrez une note valide");
        }
    }

    public Etudiant(String nom, int numeroEtudiant, List<Integer> notes){

        this.nom = nom;
        this.numeroEtudiant = numeroEtudiant;
        this.notes = notes;
    }

    public double getMoyenne(){

        double moyenne = 0;
        for (Integer note : this.notes) {
    
            moyenne = moyenne + note;
        }
        return moyenne/this.notes.size();
    }

    public int getMeilleureNote(){

        int meilleureNote = 0;
        for (Integer note : this.notes) {
    
            meilleureNote = Math.max(meilleureNote, note); //Comparer la meilleur note aux autres et la mettre à jour 
        }
        return meilleureNote;
    }

    public int getPlusBasseNote(){

        int plusBasseNote = 100;
        for (Integer note : this.notes) {
    
            plusBasseNote = Math.min(plusBasseNote, note);//Comparer la note minimale aux autres et la mettre à jour
        }
        return plusBasseNote;
    }

    public void mention(){

        if (getMoyenne()>= 90) {
            System.out.println("L\'étudiant n° " + this.numeroEtudiant +" " + this.nom +" reçoit la mention A");
        } else if (getMoyenne()>= 80) {
            System.out.println("L\'étudiant n° " + this.numeroEtudiant +" " + this.nom +" reçoit la mention B");
        } else if (getMoyenne()>= 70) {
            System.out.println("L\'étudiant n° " + this.numeroEtudiant +" " + this.nom +" reçoit la mention C");
        } else {
            System.out.println("L\'étudiant n° " + this.numeroEtudiant +" " + this.nom +" reçoit la mention D");
        }    
    }
}