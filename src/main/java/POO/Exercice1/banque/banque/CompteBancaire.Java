package banque;

public class CompteBancaire{

    private int numeroCompte;
    private String titulaire;
    private int solde;

    public CompteBancaire(int numeroCompte, String titulaire, int solde) {

        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = Math.max(0, solde);
    }

    public void deposer(int montant){

        setSolde(this.solde + montant);
    }

    public void retirer(int montant){

        if (this.solde >= montant){
        
            setSolde(this.solde - montant);
        } else {
            Sytemem.out.println("Le solde est insuffisant");
        }
    }

    public int getSolde(){

        return this.solde;
    }

    public void setSolde(int solde){

        this.solde = solde;
    }

    public void transferer(int montant, CompteBancaire compteDestination){

        this.retirer(montant); //effectuer le retrait chez le destinateur
        compteDestination.deposer(montant); //effectuer le depot chez le destinataire
    }
}
