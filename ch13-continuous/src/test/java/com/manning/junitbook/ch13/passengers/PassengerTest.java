package com.manning.junitbook.ch13.passengers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("123-45-6789", "John Smith", "US");
        assertNotNull(passenger);
    }

    @Test
    public void testInvalidCountryCode() {
        assertThrows(RuntimeException.class,
                () -> {
                    Passenger passenger = new Passenger("900-45-6789", "John Smith", "GJ");
                });
    }

    @Test
    public void testPassengerToString() {
        Passenger passenger = new Passenger("123-45-6789", "John Smith", "US");
        assertEquals("Passenger John Smith with identifier: 123-45-6789 from US", passenger.toString());
    }
}
