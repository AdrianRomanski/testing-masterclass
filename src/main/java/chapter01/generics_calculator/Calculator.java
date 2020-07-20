package chapter01.generics_calculator;

import chapter01.generics_calculator.factory.DoubleCalculator;
import chapter01.generics_calculator.factory.IntegerCalculator;
import chapter01.generics_calculator.operations.Operation;
import chapter01.generics_calculator.operations.double_operations.DoubleAdd;
import chapter01.generics_calculator.operations.double_operations.DoubleDivide;
import chapter01.generics_calculator.operations.double_operations.DoubleMultiply;
import chapter01.generics_calculator.operations.double_operations.DoubleSubtract;
import chapter01.generics_calculator.operations.integer_operations.IntegerAdd;
import chapter01.generics_calculator.operations.integer_operations.IntegerDivide;
import chapter01.generics_calculator.operations.integer_operations.IntegerMultiply;
import chapter01.generics_calculator.operations.integer_operations.IntegerSubtract;
import chapter01.generics_calculator.operations.Operations;

import java.util.HashMap;

public class Calculator {

    public static void main(String[] args) {


        // Double Calculator
        DoubleAdd add = new DoubleAdd();
        DoubleSubtract subtract = new DoubleSubtract();
        DoubleMultiply multiply = new DoubleMultiply();
        DoubleDivide divide = new DoubleDivide();

        HashMap<String, Operation<Double>> operationHashMap = new HashMap<>();
        operationHashMap.put(add.operationName().toLowerCase(), add);
        operationHashMap.put(subtract.operationName().toLowerCase(), subtract);
        operationHashMap.put(multiply.operationName().toLowerCase(), multiply);
        operationHashMap.put(divide.operationName().toLowerCase(), divide);

        Operations<Double> doubleOperations = new Operations<>(operationHashMap);

        DoubleCalculator doubleCalculator = new DoubleCalculator(doubleOperations);

        System.out.println("Double Operations");
        System.out.println(doubleCalculator.add(2.0, 2.0));
        System.out.println(doubleCalculator.subtract(4.0, 1.0));
        System.out.println(doubleCalculator.multiply(2.0, 4.0));
        System.out.println(doubleCalculator.divide(8.0, 4.0));


        // Integer Calculator
        IntegerAdd integerAdd = new IntegerAdd();
        IntegerSubtract integerSubtract = new IntegerSubtract();
        IntegerMultiply integerMultiply = new IntegerMultiply();
        IntegerDivide integerDivide = new IntegerDivide();

        HashMap<String, Operation<Integer>> integerOperationsMap = new HashMap<>();
        integerOperationsMap.put(integerAdd.operationName().toLowerCase(), integerAdd);
        integerOperationsMap.put(integerSubtract.operationName().toLowerCase(), integerSubtract);
        integerOperationsMap.put(integerMultiply.operationName().toLowerCase(), integerMultiply);
        integerOperationsMap.put(integerDivide.operationName().toLowerCase(), integerDivide);

        Operations<Integer> integerOperations = new Operations<>(integerOperationsMap);

        IntegerCalculator integerCalculator = new IntegerCalculator(integerOperations);

        System.out.println("Integer Operations");
        System.out.println(integerCalculator.add(2, 2));
        System.out.println(integerCalculator.subtract(5, 2));
        System.out.println(integerCalculator.multiply(2, 3));
        System.out.println(integerCalculator.divide(8, 3));
    }





}
