package inscription;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    
    private int numeroEtudiant;
    private String nom;
    private List<Cours> coursInscrits = new ArrayList<Cours>();

    public String getNom() {
        return nom;
    }
    
    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public List<Cours> getCoursInscrits() {
        return coursInscrits;
    }
    
    public void inscrireCours(Cours cours) {// vérifier capacité, éviter doublons
    
        getCoursInscrits().add(cours);
    }
    
    public void abandonnerCours(Cours cours){
        
        getCoursInscrits().remove(cours);
    }

}
