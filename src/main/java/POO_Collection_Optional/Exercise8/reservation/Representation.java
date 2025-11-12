package POO_Collection_Optional.Exercise8.reservation;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Representation {

    private LocalDate date;
    private Set<Place> availablePLaces;
    private Set<Reservation> reservations;

    public Representation(LocalDate date, Set<Place> availablePLaces, Set<Reservation> reservations) {
        this.date = date;
        this.availablePLaces = new HashSet<>(availablePLaces);
        this.reservations = new HashSet<>(reservations);
    }

    public void makeReservation(Reservation reservation){

        reservations.add(reservation);
        availablePLaces.forEach(place -> {
            if (Objects.equals(place.getPlaceNumber(),reservation.getPlaceNumber())){
                place.setPlaceAvailability(false);
            }
        });
    }

    public LocalDate getDate() {
        return date;
    }

    public void displayAvailablePlaces() {
        System.out.println("Places disponibles à la date " + date + " : " + availablePLaces.size());
    }
}
