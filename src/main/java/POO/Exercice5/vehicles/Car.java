public class Car extends Vehicle {

    private int numberOfDoors;
    
    public Car(int numberOfDoors){

        super();
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInformations() {

        super.displayInformations();
        System.out.println("nombre de portes: " + numberOfDoors);
    }
}
