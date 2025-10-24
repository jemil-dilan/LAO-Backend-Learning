public class Vehicle {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int price;

    public void displayInformations(){

        System.out.println(
            "Les information du vehicule"+
            "\nmarque: " + this.brand +
            "\nmodele: " + this.model +
            "\nannee: " + this.yearOfProduction +
            "\nprix: " + this.price
        );
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}