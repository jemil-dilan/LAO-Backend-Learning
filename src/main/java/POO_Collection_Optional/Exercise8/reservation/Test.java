package POO_Collection_Optional.Exercise8.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    static void main(String[] args) {

        Set<Place> places = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            places.add(new Place(i));
        }

        Representation representation1 = new Representation("Concert Jazz", LocalDate.of(2025, 11, 24), places, new HashSet<>());
        Representation representation2 = new Representation("Théâtre – Don Juan", LocalDate.of(2025, 12, 1), places, new HashSet<>());

        Theater theater = new Theater(new ArrayList<>(List.of(representation1)));
        System.out.println("Ajout d'une représentation");
        theater.addRepresentation(representation2);


        System.out.println("\nPlanning initial");
        theater.displayPlanning();


        System.out.println("\nRéservation de la place (n°3) pour Alice");
        Reservation reservation1 = new Reservation("Alice", new Place(3));
        representation1.makeReservation(reservation1);
        representation1.displayAvailablePlaces();

        System.out.println("\nRéservation de la place (n°1) pour Bob");
        Reservation reservation2 = new Reservation("Bob", new Place(1));
        representation1.makeReservation(reservation2);
        representation1.displayAvailablePlaces();


        System.out.println("\nAnnulation de la réservation d'Alice");
        representation1.undoReservation(reservation1);
        representation1.displayAvailablePlaces();


        System.out.println("\nSuppression d'une représentation");
        theater.removeRepresentation(representation2);

        System.out.println("\nPlanning final");
        theater.displayPlanning();
    }
}
