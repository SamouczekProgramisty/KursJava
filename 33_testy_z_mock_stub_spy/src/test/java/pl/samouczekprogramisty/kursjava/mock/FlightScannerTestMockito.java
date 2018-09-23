package pl.samouczekprogramisty.kursjava.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

class FlightScannerTestMockito {
    @Test
    void shouldFindLowestPrice() throws FlightException {
        String departureAirport = "departure";
        String destinationAirport = "arrival";
        LocalDate day = LocalDate.of(2018, 9, 22);
        Airline mock1 = Mockito.mock(Airline.class);
        Airline mock2 = Mockito.mock(Airline.class);

        FlightScanner flightScanner = new FlightScanner(mock1, mock2);
        flightScanner.findCheapestFlight(departureAirport, destinationAirport, day);

        Mockito.verify(mock1).findFlight(departureAirport, destinationAirport, day);
        Mockito.verify(mock2).findFlight(departureAirport, destinationAirport, day);
    }
}
