package test;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        CalculatorTest.class,
        AnotherCalculatorTest.class
})
public class CalculatorTestSuite {

}