package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class Conference extends Event{

    private String topic;

    public Conference(LocalDate date, String place, List<String> guests, String topic) {
        super(date, place, guests);
        this.topic = topic;
    }
}
