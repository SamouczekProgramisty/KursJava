package pl.samouczekprogramisty.kursjava.mock;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FlightScannerTestStubs {

    private Airline stub1 = (departureAirport, destinationAirport, flightDate) -> Collections.singletonList(
            new Flight("AB1234", new BigDecimal(100), "WRO", "BCN")
    );

    private Airline stub2 = (departureAirport, destinationAirport, flightDate) -> Collections.singletonList(
            new Flight("AB2345", new BigDecimal(200), "WRO", "BCN")
    );

    private Airline stub3 = (departureAirport, destinationAirport, flightDate) -> { throw new FlightException("BOOM!"); };

    @Test
    void shouldFindLowestPrice() {
        FlightScanner flightScanner = new FlightScanner(stub1, stub2, stub3);
        assertThat(flightScanner.findCheapestFlight("not", "important", null).getFlightNumber(), is("AB1234"));
    }
}