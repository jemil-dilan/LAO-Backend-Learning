package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class Conference extends Event{

    public Conference(LocalDate date, String place, List<Guest> guests) {
        super(date, place, guests);
    }
}
