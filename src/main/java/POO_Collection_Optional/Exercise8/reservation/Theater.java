package POO_Collection_Optional.Exercise8.reservation;

import java.util.List;

public class Theater {

    private List<Representation> representations;

    public Theater(List<Representation> representations) {
        this.representations = representations;
    }

    public void displayPlanning() {
        System.out.println("Planning des représentations :");
        for (Representation representation : representations) {

            System.out.println(representation);
        }
    }

    public void addRepresentation(Representation representation){

        representations.add(representation);
    }

    public void removeRepresentation(Representation representation){

        representations.remove(representation);
    }
}
