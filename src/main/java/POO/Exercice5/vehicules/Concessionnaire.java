import java.util.ArrayList;
import java.util.List;

public class Concessionnaire {
    
    private List<Vehicules> listeDeVehicule = new ArrayList<Vehicules>();

    public Concessionnaire (Vehicules vehicule){

        listeDeVehicule.add(vehicule);
    }

    public Concessionnaire (List<Vehicules> vehicules){

        listeDeVehicule.addAll(vehicules);
    }

    public void filtrerParType (String marque){

        System.out.println("Véhicules de la marque " + marque);
        
        for (Vehicules vehicule : listeDeVehicule) {

            if (vehicule.getMarque() == marque) {
                
                System.out.println("auto: " + vehicule.getModele());   
            }
        }
    }
}
