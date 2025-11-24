package POO_Collection_Optional.Exercise8.reservation;

public class Reservation {

    private String spectatorName;
    private Place place;

    public Reservation(String spectatorName, Place place) {

        this.spectatorName = spectatorName;
        this.place = place;
        this.place.setPlaceAvailability(false);
    }

    public String getSpectatorName() {
        return spectatorName;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Spectator: " + spectatorName + ", place n°" + place.getPlaceNumber();
    }
}
