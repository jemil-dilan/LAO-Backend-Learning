package Exercise5.vehicleFleetManager;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class VehicleFleet {

    Set<Vehicle> vehicles;

    public VehicleFleet(Set<Vehicle> vehicles) {
        this.vehicles = new LinkedHashSet<Vehicle>(vehicles);
    }

    public void addVehicle(Vehicle vehicle){

        vehicle.setAvailable(true);
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

        vehicle.setAvailable(false);
        vehicles.remove(vehicle);
    }

    public void lookForVehicle(int id){

        System.out.println(vehicles.stream().filter(vehicle -> Objects.nonNull(vehicle) && Objects.equals(vehicle.getIdNumber() , id)));
    }

    public Optional<Vehicle> findVehicleById (int id) {

        return vehicles.stream().filter(vehicle -> Objects.nonNull(vehicle) && Objects.equals(vehicle.getIdNumber() , id)).findFirst();
    }

    public Optional<Vehicle> findOldestVehicle() {

        return  vehicles.stream().filter(Objects::nonNull).reduce((vehicle1, vehicle2) ->  vehicle1.getYearOfProduction() >= vehicle2.getYearOfProduction() ? vehicle1 : vehicle2);
    }
}
