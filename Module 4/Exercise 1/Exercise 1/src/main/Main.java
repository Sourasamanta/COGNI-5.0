package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        Operation operation = null;

        switch (op) {
            case '+':
                operation = new AddOperation();
                break;
            case '-':
                operation = new SubtractOperation();
                break;
            case '*':
                operation = new MultiplyOperation();
                break;
            case '/':
                operation = new DivideOperation();
                break;
            default:
                System.out.println("Invalid operator");
                System.exit(0);
        }

        Calculator calculator = new Calculator(operation);

        try {
            double result = calculator.calculate(num1, num2);
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}