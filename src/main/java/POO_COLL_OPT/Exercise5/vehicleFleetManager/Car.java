package POO_COLL_OPT.Exercise5.vehicleFleetManager;

public class Car extends Vehicle{

    private int placesNumber;

    public Car(int yearOfProduction, int idNumber, String brand, String model) {
        super(yearOfProduction, idNumber, brand, model);
    }

    public void setPlacesNumber(int placesNumber) {
        this.placesNumber = placesNumber;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "placesNumber=" + placesNumber +
                '}';
    }
}
