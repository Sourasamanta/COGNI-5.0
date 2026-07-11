package test;

import main.PerformanceTester;

import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();


    @Test
    void testPerformanceWithinTimeLimit() {

        assertTimeout(Duration.ofSeconds(2), () -> {
            tester.performTask();
        });
    }


    @Test
    void testPerformanceFailsWhenTooSlow() {

        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        });
    }
}