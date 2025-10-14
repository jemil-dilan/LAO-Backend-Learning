package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Membre {
    
    private String  nom;
    private List<Livre> livresEmprunte = new ArrayList <Livre> ();
    
    public Membre (String nom){
        
        this.nom = nom;
    }

    public List<Livre> getLivresEmprunte() {
        return livresEmprunte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
