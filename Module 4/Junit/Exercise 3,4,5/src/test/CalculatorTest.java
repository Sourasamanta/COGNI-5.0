package test;

import main.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @Order(1)
    void testAddition() {
        assertEquals(10, calculator.add(5, 5));
        System.out.println("Addition test completed");
    }

    @Test
    @Order(2)
    void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        System.out.println("Subtraction test completed");
    }

    @Test
    @Order(3)
    void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5));
        System.out.println("Multiplication test completed");
    }

    @Test
    @Order(4)
    void testDivision() {
        assertEquals(5, calculator.divide(10, 2));
        System.out.println("Division test completed");
    }

    @Test
    @Order(5)
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));
        System.out.println("Division by zero test completed");
    }
}