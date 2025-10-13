import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Animal> listeAnimal = new ArrayList<Animal>();
    
    public void nourriTousLesAnimaux(){

        for (Animal animal : listeAnimal) {
            
            animal.manger();
        }
    }

    public void heureNuit(){

        for (Animal animal : listeAnimal) {
            
            animal.dormir();
        }
    }
}