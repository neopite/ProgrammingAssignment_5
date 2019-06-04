package com.company.ShutingYard;


public class Operators {
    public Operators() {
    }

    public static double calculate(double a, double b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else if (operator.equals("/")) {
            return a / b;
        } else {
            return operator.equals("^") ? Math.pow(a, b) : 0.0D;
        }
    }
}
