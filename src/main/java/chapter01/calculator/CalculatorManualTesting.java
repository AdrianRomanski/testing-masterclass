package chapter01.calculator;

import chapter01.calculator.client.Calculator;
import chapter01.calculator.operations.*;

import java.util.Arrays;

public class CalculatorManualTesting {


    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Operation add = new Add();
        Operation subtraction = new Subtraction();
        Operation multiply = new Multiply();
        Operation divide = new Divide();

        // Checking single Add
        calculator.addOperation(add);

        // Checking adding many
        calculator.addOperations(Arrays.asList(subtraction, multiply, divide));

        // Adding duplicate
        calculator.addOperation(add);
        System.out.println(calculator.toString());

        // Checking all Operations
        System.out.println(calculator.getOperation("ADd").calculate(2.0, 2.0));
        System.out.println(calculator.getOperation("dIvIdE").calculate(4.0, 2.0));
        System.out.println(calculator.getOperation("MULTIPLY").calculate(2.0, 4.0));
        System.out.println(calculator.getOperation("SUbTraction").calculate(2.0, 1.0));



    }
}
