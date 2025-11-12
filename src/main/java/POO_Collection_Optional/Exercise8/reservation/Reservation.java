package POO_Collection_Optional.Exercise8.reservation;

public class Reservation {

    private String spectatorName;
    private int placeNumber;

    public Reservation(String spectatorName, int placeNumber) {
        this.spectatorName = spectatorName;
        this.placeNumber = placeNumber;
    }

    public String getSpectatorName() {
        return spectatorName;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    @Override
    public String toString() {
        return "Spectator: " + spectatorName + ", place n°" + placeNumber;
    }
}
