package main;

public class ExceptionThrower {

    public void throwException() {
        throw new IllegalArgumentException("Invalid operation");
    }

    public void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}