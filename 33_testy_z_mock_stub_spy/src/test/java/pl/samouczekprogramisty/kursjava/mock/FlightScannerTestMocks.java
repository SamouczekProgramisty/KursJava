package pl.samouczekprogramisty.kursjava.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

class FlightScannerTestMocks {

    private static final class AirlineMock implements Airline {

        private static final class MethodInvocation {
            String departureAirport;
            String arrivalAirport;
            LocalDate flightDate;

            MethodInvocation(String departureAirport, String arrivalAirport, LocalDate flightDate) {
                this.departureAirport = departureAirport;
                this.arrivalAirport = arrivalAirport;
                this.flightDate = flightDate;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                MethodInvocation methodInvocation = (MethodInvocation) o;
                return Objects.equals(departureAirport, methodInvocation.departureAirport) &&
                        Objects.equals(arrivalAirport, methodInvocation.arrivalAirport) &&
                        Objects.equals(flightDate, methodInvocation.flightDate);
            }

            @Override
            public int hashCode() {
                return Objects.hash(departureAirport, arrivalAirport, flightDate);
            }
        }

        private final Set<MethodInvocation> invocations = new HashSet<>();

        void verifyCalled(String departureAirport, String destinationAirport, LocalDate flightDate) {
            boolean wasCalled = invocations.contains(new MethodInvocation(departureAirport, destinationAirport, flightDate));
            if (!wasCalled) {
                throw new AssertionError("One of the expected invocations wasn't called!");
            }
        }

        @Override
        public List<Flight> findFlight(String departureAirport, String destinationAirport, LocalDate flightDate) {
            invocations.add(new MethodInvocation(departureAirport, destinationAirport, flightDate));
            return Collections.emptyList();
        }
    }

    @Test
    void shouldFindLowestPrice() {
        String departureAirport = "departure";
        String destinationAirport = "arrival";
        LocalDate day = LocalDate.of(2018, 9, 22);
        AirlineMock mock1 = new AirlineMock();
        AirlineMock mock2 = new AirlineMock();

        FlightScanner flightScanner = new FlightScanner(mock1, mock2);
        flightScanner.findCheapestFlight(departureAirport, destinationAirport, day);

        mock1.verifyCalled(departureAirport, destinationAirport, day);
        mock2.verifyCalled(departureAirport, destinationAirport, day);
    }

}
