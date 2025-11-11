package POO_COLL_OPT.Exercise5.vehicleFleetManager;

public class Truck extends Vehicle{

    private String typeOfFuel;

    public Truck(int yearOfProduction, int idNumber, String brand, String model) {
        super(yearOfProduction, idNumber, brand, model);
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "typeOfFuel='" + typeOfFuel + '\'' +
                '}';
    }
}
