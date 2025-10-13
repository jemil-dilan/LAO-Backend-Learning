package paie;

public class EmployeTempsPlein extends Employe{
    
    private double avantages;

    public EmployeTempsPlein(String nom, int numeroEmploye, int salaireBase, double avantages){

        super(nom, numeroEmploye, salaireBase);
        this.avantages = avantages;
    }

    @Override
    public double calculerSalaire() {
        // TODO Auto-generated method stub
        return salaireBase + avantages;
    }
}
