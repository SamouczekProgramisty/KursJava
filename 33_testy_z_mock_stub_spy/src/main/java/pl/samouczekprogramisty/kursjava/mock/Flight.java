package pl.samouczekprogramisty.kursjava.mock;

import java.math.BigDecimal;

public class Flight {
    private final String flightNumber;
    private final BigDecimal price;
    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(String flightNumber, BigDecimal price, String departureAirport, String arrivalAirport) {
        this.flightNumber = flightNumber;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
