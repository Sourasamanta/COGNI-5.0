package test;

import main.ExceptionThrower;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void testExceptionIsThrown() {

        assertThrows(IllegalArgumentException.class, () -> {
            exceptionThrower.throwException();
        });
    }


    @Test
    void testDivideByZeroException() {

        assertThrows(ArithmeticException.class, () -> {
            exceptionThrower.divide(10, 0);
        });
    }
}