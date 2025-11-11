package POO.Exercice5.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleDealerShip {
    
    private List<Vehicle> listeDeVehicule = new ArrayList<Vehicle>();

    public VehicleDealerShip(List<Vehicle> vehicules){

        listeDeVehicule.addAll(vehicules);
    }

    public void filterByType(String brand){

        System.out.println("Véhicules de la marque " + brand);
        
        for (Vehicle vehicule : listeDeVehicule) {

            if (Objects.equals(vehicule.getBrand(), brand)) {
                
                vehicule.displayInformations();
            }
        }
    }
}
