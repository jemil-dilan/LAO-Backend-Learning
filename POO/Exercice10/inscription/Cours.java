package inscription;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    
    private int codeCours;
    private String nomCours;
    private String professeur;
    private int capaciteMax;
    private List<Etudiant> etudiantsInscrits = new ArrayList<Etudiant>();

    public Cours(int codeCours, String nomCours, String professeur,int capaciteMax, List<Etudiant> etudiantsInscrits){

        this.codeCours = codeCours;
        this.nomCours = nomCours;
        this.professeur = professeur;
        this.capaciteMax = Math.max(capaciteMax, 5);
        this.etudiantsInscrits = etudiantsInscrits;        
    }

    public String getNomCours() {
        return nomCours;
    }

    public String getProfesseur() {
        return professeur;
    }

    public int getCodeCours() {
        return codeCours;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public List<Etudiant> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }

    public void setEtudiantsInscrits(List<Etudiant> etudiantsInscrits) {
        this.etudiantsInscrits = etudiantsInscrits;
    }

    public void ajouterEtudiant(Etudiant etudiant){ // valider capacité
    
        if (capaciteMax < etudiantsInscrits.size()) {
            
            etudiantsInscrits.add(etudiant);
        } else {
            
            System.out.println("Le nombre maximal d\'étudiant a été atteind pour ce cours");
        }
        
    }
}
