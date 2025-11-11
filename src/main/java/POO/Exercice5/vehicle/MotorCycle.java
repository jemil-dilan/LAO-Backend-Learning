package POO.Exercice5.vehicle;

public class MotorCycle extends Vehicle {
   
    private int aSidecar;
    
    public MotorCycle(int aSidecar){

        super();
        this.aSidecar = aSidecar;
    }

    @Override
    public void displayInformations() {

        super.displayInformations();
        System.out.println("nombre de portes: " + this.aSidecar);
    }
}