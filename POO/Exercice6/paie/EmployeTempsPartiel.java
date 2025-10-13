package paie;

public class EmployeTempsPartiel extends Employe{

    private int heuresTravaillees;
    private double tauxHoraire;

    private EmployeTempsPartiel (String nom,int numeroEmploye,int salaireBase, int heuresTravaillees, double tauxHoraire){

        super(nom, numeroEmploye, salaireBase);
        this.heuresTravaillees = heuresTravaillees;
        this.tauxHoraire = tauxHoraire;
    }

    @Override
    public double calculerSalaire() {
        // TODO Auto-generated method stub
        return heuresTravaillees * tauxHoraire;
    }
}

