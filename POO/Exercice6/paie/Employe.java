package paie;

public abstract class Employe {
    
    protected String nom;
    protected int numeroEmploye;
    protected int salaireBase;

    public Employe (String nom,int numeroEmploye,int salaireBase){
        
        this.nom = nom;
        this.numeroEmploye = numeroEmploye; 
        this.salaireBase = salaireBase;
    }
    
    public String getNom() {
        return nom;
    }

    public int getNumeroEmploye() {
        return numeroEmploye;
    }
    
    public int getSalaireBase() {
        return salaireBase;
    }

    public abstract double calculerSalaire();
}
