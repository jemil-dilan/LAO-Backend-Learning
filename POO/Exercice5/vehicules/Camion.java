public class Camion extends Vehicules{
    
    private int capaciteChargement;
    
    public Camion(int capaciteChargement){

        super();
        this.capaciteChargement = capaciteChargement;
    }

    @Override
    public void afficherInfo() {
        // TODO Auto-generated method stub
        super.afficherInfo();
        System.out.println("capacite de chargement: " + this.capaciteChargement);
    }
}
