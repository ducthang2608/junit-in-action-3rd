package com.manning.junitbook.ch13.flightspassengers;
import com.manning.junitbook.ch13.flights.Flight;
import com.manning.junitbook.ch13.passengers.Passenger;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class FlightWithPassengersTest {
    private Flight flight = new Flight("AA123", 1);

    @Test
    public void testPassengerJoinsFlight() {
        Passenger passenger = new Passenger("123-45-6789", "John Smith", "US");
        passenger.joinFlight(flight);
        assertEquals(flight, passenger.getFlight());
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void testAddRemovePassengers() throws IOException {
        Passenger passenger = new Passenger("124-56-7890", "Michael Johnson", "US");
        assertTrue(flight.addPassenger(passenger));
        assertEquals(2, flight.getNumberOfPassengers());
        assertEquals(flight, passenger.getFlight());

        assertTrue(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
        assertEquals(null, passenger.getFlight());
    }

    @Test
    public void testNumberOfSeats() {
        Passenger passenger1 = new Passenger("124-56-7890", "Michael Johnson", "US");
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getNumberOfPassengers());

        Passenger passenger2 = new Passenger("127-23-7991", "John Smith", "GB");
        assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));

    }
}
