package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsManager {

   private List<Event> events;

    public EventsManager(List<Event> events) {
        this.events = new ArrayList<>(events);
    }

    public void addAnEvent(Event event){

        events.add(event);
    }

    public void removeAnEvent(Event event){

        events.remove(event);
    }

    public void listAllEventsAtTheDate(LocalDate date){

        System.out.println("List of elements at the date of : " + date);
        events.stream()
                .filter(event -> event.getDate().isEqual(date))
                .forEach(System.out::println);
    }
}
