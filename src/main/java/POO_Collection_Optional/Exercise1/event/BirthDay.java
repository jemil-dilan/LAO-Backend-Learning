package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class BirthDay extends Event{

    private String  birthDayOwnerName;

    public BirthDay(LocalDate date, String place, List<Guest> guests, String birthDayOwnerName) {
        super(date, place, guests);
        this.birthDayOwnerName = birthDayOwnerName;
    }
}
