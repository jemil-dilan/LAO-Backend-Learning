package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class Concert extends Event{

    private String artist;
    private int placeLimit;

    public Concert(LocalDate date, String place, List<String> guests, String artist, int placeLimit) {
        super(date, place, guests);
        this.artist = artist;
        this.placeLimit = placeLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "Concert of the " +
                "artist='" + artist + '\'' +
                '}';
    }
}
