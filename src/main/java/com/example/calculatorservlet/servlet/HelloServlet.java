package com.example.calculatorservlet.servlet;

import java.io.*;
import java.text.DecimalFormat;

import com.example.calculatorservlet.operations.AdditionOperation;
import com.example.calculatorservlet.operations.DivisionOperation;
import com.example.calculatorservlet.operations.MultiplicationOperation;
import com.example.calculatorservlet.operations.SubtractionOperation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String num1Str = request.getParameter("num1");
        num1Str = num1Str.trim();
        String num2Str = request.getParameter("num2");
        num2Str = num2Str.trim();
        String operation = request.getParameter("operation");

        boolean num1Error = false;
        boolean num2Error = false;
        boolean operationError = false;
        double result = 0;

            double num1;
            if (num1Str != null && num1Str.matches("^-?\\d+(\\.\\d+)?$")) {
                num1 = Double.parseDouble(num1Str);
            } else {
                num1Error = true;
                num1 = Double.NaN;
            }

            double num2;
            if (num2Str != null && num2Str.matches("^-?\\d+(\\.\\d+)?$")) {
                num2 = Double.parseDouble(num2Str);
            } else {
                num2Error = true;
                num2 = Double.NaN;
            }

            char operator = operation.charAt(0);
            if (!String.valueOf(operator).matches("[+\\-*/]")) {
            operationError = true;
            }

            if(num1Error || num2Error) {
                response.getWriter().println("Number format error. Enter the number in the correct form, for example '123' or '12.34'");
            }

        if (num1Error) {
            response.getWriter().println("Invalid first number");
        }

        if (num2Error) {
            response.getWriter().println("Invalid second number");
        }
        if (operationError) {
            response.getWriter().println("Invalid operation. Please enter the correct operation (+, -, *, /) and try again.");
        }

        if (!num1Error && !num2Error && !operationError) {
                switch (operator) {
                    case '+':
                        AdditionOperation run1 = new AdditionOperation();
                        result = run1.operatorCalculate(num1, num2);
                        break;
                    case '-':
                        SubtractionOperation run2 = new SubtractionOperation();
                        result = run2.operatorCalculate(num1, num2);
                        break;
                    case '*':
                        MultiplicationOperation run3 = new MultiplicationOperation();
                        result = run3.operatorCalculate(num1, num2);
                        break;
                    case '/':
                        if (num2 != 0) {
                            DivisionOperation run4 = new DivisionOperation();
                            result = run4.operatorCalculate(num1, num2);
                        } else {
                            response.getWriter().println("The division by zero operation is not allowed. Please enter a different division number to continue");
                            return;
                        }
                        break;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.###");
                String formattedResult = decimalFormat.format(result);
                response.getWriter().println("Result: " + formattedResult);
            }
    }


//        if (operation != null && operation.matches("[+\\-*/]")) {
//            if(num1Str != null && num1Str.matches("^-?\\d+(\\.\\d+)?$") &&
//                    num2Str != null && num2Str.matches("^-?\\d+(\\.\\d+)?$")) {
//                    double num1 = Double.parseDouble(num1Str);
//                    double num2 = Double.parseDouble(num2Str);
//                    char operator = operation.charAt(0);
//                    double result = 0;
//
//                    switch (operator) {
//                        case '+':
//                            AdditionOperation run1 = new AdditionOperation();
//                            result = run1.operatorCalculate(num1,num2);
//                            break;
//                        case '-':
//                            SubtractionOperation run2 = new SubtractionOperation();
//                            result = run2.operatorCalculate(num1,num2);
//                            break;
//                        case '*':
//                            MultiplicationOperation run3 = new MultiplicationOperation();
//                            result = run3.operatorCalculate(num1,num2);
//                            break;
//                        case '/':
//                            if (num2 != 0) {
//                                DivisionOperation run4 = new DivisionOperation();
//                                result = run4.operatorCalculate(num1,num2);
//                            } else {
//                                response.getWriter().println("The division by zero operation is not allowed. Please enter a different division number to continue");
//                                return;
//                            }
//
//                            break;
//                    }
//                DecimalFormat decimalFormat = new DecimalFormat("#.###");
//                String formattedResult = decimalFormat.format(result);
//                response.getWriter().println("Result: " + formattedResult);
//            } else {
//                response.getWriter().println("Number format error. Enter the number in the correct form, for example '123' or '12.34'");
//            }
//        } else {
//            response.getWriter().println("Invalid operation. Please enter the correct operation (+, -, *, /) and try again.");
//        }

        public void destroy () {
        }
    }
