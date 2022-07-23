package com.manning.junitbook.ch02.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertAllTest {
    @Test
    @DisplayName("SUT should default to not being under current verification")
    void testSystemNotVerified() {
        SUT sut = new SUT("Our system under test");

        assertAll("By default, SUT is not under current verification",
                () -> assertEquals("Our system under test", sut.getSystemName()),
                () -> assertFalse(sut.isVerified()));
    }

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification() {
        SUT sut = new SUT("Our system under test");
        sut.verify();
        assertAll("SUT should be under current verification",
                () -> assertEquals("Our system under test", sut.getSystemName()),
                () -> assertTrue(sut.isVerified()));
    }
}
