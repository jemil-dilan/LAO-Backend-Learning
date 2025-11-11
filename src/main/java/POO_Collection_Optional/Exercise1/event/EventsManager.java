package POO_Collection_Optional.Exercise1.event;

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

}
