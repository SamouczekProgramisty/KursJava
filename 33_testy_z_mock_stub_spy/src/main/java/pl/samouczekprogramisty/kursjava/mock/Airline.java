package pl.samouczekprogramisty.kursjava.mock;

import java.time.LocalDate;
import java.util.List;

public interface Airline {
    List<Flight> findFlight(String departureAirport, String destinationAirport, LocalDate flightDate) throws FlightException;
}
