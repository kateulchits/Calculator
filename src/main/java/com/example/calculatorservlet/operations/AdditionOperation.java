package com.example.calculatorservlet.operations;

public class AdditionOperation extends MathOperator {

    @Override
     public double operatorCalculate(double num1, double num2) {
//        DecimalFormat df = new DecimalFormat("###.####");
        this.num1 = num1;
        this.num2 = num2;
        double result = 0.0;
        result = num1 + num2;
//        System.out.println(num1 + " + " + num2 + " = " + df.format(result));
        return result;
    }
}
