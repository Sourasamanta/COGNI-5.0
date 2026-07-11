package test;

import main.isEven;
import main.checks;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isEvenTest {

    @BeforeAll
    static void setup(){
        System.out.println("Setting up...");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void isEvenTest1(int a) {

        // Arrange
        checks chk = new isEven();

        // Act
        boolean result = chk.calculate(a);

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void isEvenTest2(int a) {

        // Arrange
        checks chk = new isEven();

        // Act
        boolean result = chk.calculate(a);

        // Assert
        assertFalse(result);
    }

}