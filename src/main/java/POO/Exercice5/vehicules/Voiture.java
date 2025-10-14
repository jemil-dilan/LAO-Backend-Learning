public class Voiture extends Vehicules{

    private int nombrePortes;
    
    public Voiture(int nombrePortes){

        super();
        this.nombrePortes = nombrePortes;
    }

    @Override
    public void afficherInfo() {
        // TODO Auto-generated method stub
        super.afficherInfo();
        System.out.println("nombre de portes: " + this.nombrePortes);
    }
}
