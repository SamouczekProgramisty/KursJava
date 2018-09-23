package pl.samouczekprogramisty.kursjava.mock;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoExamplesTest {

    @Mock
    Airline airlineMock;

    @Test
    void shouldCreateMockInstance() {
        assertThat(airlineMock, is(notNullValue()));
    }

    @Test
    void verifyExamples1() throws FlightException {
        airlineMock.findFlight("exactValue", "exactValue", LocalDate.now());

        verify(airlineMock).findFlight("exactValue", "exactValue", LocalDate.now());
    }

    @Test
    void verifyExamples2() throws FlightException {
        airlineMock.findFlight("exactValue", "exactValue", LocalDate.now());

        verify(airlineMock, atMost(10)).findFlight(anyString(), any(), Mockito.any(LocalDate.class));
    }

    @Test
    void verifyExamples3() throws FlightException {
        airlineMock.findFlight("exactValue", "exactValue", LocalDate.now());

        verify(airlineMock, atLeastOnce()).findFlight(contains("Val"), Mockito.startsWith("ex"), eq(LocalDate.now()));
    }

    @Test
    void whenExamples1() throws FlightException {
        List<Flight> flight = airlineMock.findFlight("a", "b", LocalDate.now());
        assertThat(flight, is(notNullValue()));
        assertThat(flight, is(empty()));
    }

    @Test
    void whenExamples2() throws FlightException {
        when(airlineMock.findFlight(any(), any(), any())).thenThrow(new FlightException("some message"));

        assertThrows(FlightException.class, () -> airlineMock.findFlight("a", "b", LocalDate.now()));
    }

    @Test
    void whenExamples3() throws FlightException {
        Flight someFlight = new Flight("ABC123", BigDecimal.TEN, "departure", "arriva");
        when(airlineMock.findFlight("a", "b", LocalDate.now()))
                .thenReturn(Collections.singletonList(someFlight));

        List<Flight> flight = airlineMock.findFlight("a", "b", LocalDate.now());
        assertThat(flight.size(), is(1));
        assertThat(flight.get(0), is(someFlight));
    }
}
