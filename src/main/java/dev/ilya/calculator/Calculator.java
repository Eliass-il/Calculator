package dev.ilya.calculator;

public class Calculator {
    public Calculator() {
    }

    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return -1;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}
