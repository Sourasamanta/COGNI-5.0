package test;

import main.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnotherCalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void testDivision() {
        assertEquals(5, calculator.divide(10, 2));
    }
}