package paie;

public class Contractuel extends Employe{
 
    private int nombreProjets;
    private double tauxProjet;    

    public Contractuel (String nom,int numeroEmploye,int salaireBase, int nombreProjets, double tauxProjet){
        
        super(nom, numeroEmploye, salaireBase);
        this.nombreProjets = nombreProjets;
        this.tauxProjet = tauxProjet;    
    }

    @Override
    public double calculerSalaire() {
        // TODO Auto-generated method stub
        return tauxProjet * nombreProjets;
    }
}
