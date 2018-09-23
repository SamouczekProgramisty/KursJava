package pl.samouczekprogramisty.kursjava.mock;

import java.time.LocalDate;
import java.util.*;

public class FlightScanner {

    private final Airline[] airlines;

    public FlightScanner(Airline... airlines) {
        this.airlines = airlines;
    }

    public Flight findCheapestFlight(String departure, String destination, LocalDate flightDate) {
        Optional<Flight> cheapestFlight = Arrays.stream(airlines)
                .map(a -> {
                    try {
                        return a.findFlight(departure, destination, flightDate);
                    } catch (FlightException e) {
                        // log
                        List<Flight> empty = Collections.emptyList();
                        return empty;
                    }
                })
                .flatMap(List::stream)
                .min(Comparator.comparing(Flight::getPrice));

        return cheapestFlight.orElse(null);
    }
}
