package com.manning.junitbook.ch02.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class AssertTimeoutTest {
    private SUT sut = new SUT("Our system under test");

    @Test
    @DisplayName("A job is executed within a timeout")
    void testTimeout() throws InterruptedException {
        sut.addJob(new Job("Job 1"));
        Assertions.assertTimeout(Duration.ofMillis(290), () -> sut.run(200));
    }

    @Test
    @DisplayName("A job is executed preemptively within a timeout")
    void testTimeoutPreemptively() throws InterruptedException {
        sut.addJob(new Job("Job 1"));
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(280), () -> sut.run(200));
    }
}
