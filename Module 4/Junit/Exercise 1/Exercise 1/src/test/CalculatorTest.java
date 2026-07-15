package test;

import main.AddOperation;
import main.Calculator;
import main.DivideOperation;
import main.MultiplyOperation;
import main.SubtractOperation;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Setup");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Teardown");
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator(new AddOperation());
        double result = calculator.calculate(5, 3);
        Assert.assertEquals(result, 8.0);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator(new SubtractOperation());
        double result = calculator.calculate(5, 3);
        Assert.assertEquals(result, 2.0);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator(new MultiplyOperation());
        double result = calculator.calculate(5, 3);
        Assert.assertEquals(result, 15.0);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator(new DivideOperation());
        double result = calculator.calculate(6, 3);
        Assert.assertEquals(result, 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator(new DivideOperation());
        calculator.calculate(5, 0);
    }
}