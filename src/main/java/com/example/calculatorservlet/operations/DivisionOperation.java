package com.example.calculatorservlet.operations;


public class DivisionOperation extends MathOperator {
    @Override
    public double operatorCalculate(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        double result;
        if (num2 == 0) {
            throw new ArithmeticException("Dividing by zero is undefined");
        } else {
            result = num1 / num2;
        }
        return result;




//        try {
//            this.num1 = num1;
//            this.num2 = num2;
//            double result = 0.0;
//            result = num1 / num2;
//            System.out.println(num1 + " / " + num2 + " = " + result);
//        } catch (ArithmeticException ex) {
//            System.out.println("Dividing by zero is undefined ");
//            Operation op1 = new Operation();
//            op1.getOperation(num1,num2);
        }
    }

