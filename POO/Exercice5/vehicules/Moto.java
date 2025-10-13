public class Moto extends Vehicules{
   
    private int aSidecar;
    
    public Moto(int aSidecar){

        super();
        this.aSidecar = aSidecar;
    }

    @Override
    public void afficherInfo() {
        // TODO Auto-generated method stub
        super.afficherInfo();
        System.out.println("nombre de portes: " + this.aSidecar);
    }
}
