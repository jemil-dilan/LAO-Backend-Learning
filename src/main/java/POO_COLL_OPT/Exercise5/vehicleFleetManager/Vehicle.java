package POO_COLL_OPT.Exercise5.vehicleFleetManager;

public class Vehicle {

    private boolean available;
    private int yearOfProduction;
    private int idNumber;
    private String brand;
    private String model;

    public Vehicle(int yearOfProduction, int idNumber, String brand, String model) {
        this.yearOfProduction = yearOfProduction;
        this.idNumber = idNumber;
        this.brand = brand;
        this.model = model;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "available=" + available +
                ", yearOfProduction=" + yearOfProduction +
                ", idNumber=" + idNumber +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' ;
    }
}
