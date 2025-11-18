package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.List;

public class Event {

   protected LocalDate date;
   protected String place;
   protected List<Guest> guests;

    public Event(LocalDate date, String place, List<Guest> guests) {
        this.date = date;
        this.place = place;
        this.guests = guests;
    }

    public void addSomeGuest(Guest guest){

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
