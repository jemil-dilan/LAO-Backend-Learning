package POO_Collection_Optional.Exercise8.reservation;

public class Place {

    private int placeNumber;
    private boolean placeAvailability;

    public Place(int placeNumber, String category) {
        this.placeNumber = placeNumber;
        this.placeAvailability = true;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public boolean isPlaceAvailability() {
        return placeAvailability;
    }

    public void setPlaceAvailability(boolean placeAvailability) {
        this.placeAvailability = placeAvailability;
    }
}
