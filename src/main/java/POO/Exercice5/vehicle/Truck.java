package vehicle;

public class Truck extends Vehicle {
    
    private int loadingCapacity;
    
    public Truck(int loadingCapacity){

        super();
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public void displayInformations() {

        super.displayInformations();
        System.out.println("capacite de chargement: " + this.loadingCapacity);
    }
}
