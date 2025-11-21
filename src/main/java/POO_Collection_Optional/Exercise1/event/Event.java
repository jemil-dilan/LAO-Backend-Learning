package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class Event {

   protected LocalDate date;
   protected String place;
   protected List<String> guests;

    public Event(LocalDate date, String place, List<String> guests) {
        this.date = date;
        this.place = place;
        this.guests = guests;
    }

    public void addSomeGuest(String guest){

        guests.add(guest);
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "place='" + place + '\'' +
                ", date=" + date +
                '}';
    }
}
