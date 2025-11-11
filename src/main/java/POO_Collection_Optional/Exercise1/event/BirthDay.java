package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class BirthDay extends Event{

    public BirthDay(LocalDate date, String place, List<Guest> guests) {
        super(date, place, guests);
    }
}
