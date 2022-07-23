package com.manning.junitbook.ch02.assumptions;

import com.manning.junitbook.ch02.assumptions.environment.JavaSpecification;
import com.manning.junitbook.ch02.assumptions.environment.OperationSystem;
import com.manning.junitbook.ch02.assumptions.environment.TestsEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionsTest {
    private static String EXPECTED_JAVA_VERSION = "1.8";

    private TestsEnvironment environment = new TestsEnvironment(new JavaSpecification(System.getProperty("java.vm.specification.version")),
            new OperationSystem(System.getProperty("os.name"), System.getProperty("os.arch")));

    private SUT sut = new SUT();

    @BeforeEach
    void setUp() {
        assumeTrue(environment.isWindows());
    }

    @Test
    void testNoJobToRun() {
        assumingThat(() -> environment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
                () -> assertFalse(sut.hasJobToRun()));
    }

    @Test
    void testJobToRun() {
        assumeTrue(environment.isAmd64Architecture());
        sut.run(new Job());
        assertTrue(sut.hasJobToRun());
    }

}
