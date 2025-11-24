package POO_Collection_Optional.Exercise1.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    static void main(String[] args) {

        String[] guestNames = {"Pablo", "Perrota", "manci"};
        List<String> guests = new ArrayList<>(Arrays.stream(guestNames).toList());

        BirthDay birthDay = new BirthDay(LocalDate.of(2025, 3, 10), "NdogBong", guests, "Adon");
        Concert concert = new Concert(LocalDate.of(2025, 8, 12), "NdogBong", guests, "Tini", 600);
        Conference conference = new Conference(LocalDate.of(2025, 3, 10), "NdogBong", guests, "Adon attitude");

        List<Event> events = new ArrayList<Event>();
        events.add(birthDay);
        events.add(concert);
        events.add(conference);

        EventsManager eventsManager = new EventsManager(events);
        eventsManager.addAnEvent(conference);

//        eventsManager.listAllEventsAtTheDate(LocalDate.of(2025, 3, 10));

        eventsManager.removeAnEvent(conference);

        eventsManager.listAllEventsAtTheDate(LocalDate.of(2027, 3, 10));
    }
}
