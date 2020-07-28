package chapter01;

import chapter01.generics_calculator.factory.DoubleCalculator;
import chapter01.generics_calculator.operations.Operation;
import chapter01.generics_calculator.operations.Operations;
import chapter01.generics_calculator.operations.double_operations.DoubleAdd;
import chapter01.generics_calculator.operations.double_operations.DoubleDivide;
import chapter01.generics_calculator.operations.double_operations.DoubleMultiply;
import chapter01.generics_calculator.operations.double_operations.DoubleSubtract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {

    DoubleCalculator calculator;


    @BeforeEach
    void init() {
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

        calculator = new DoubleCalculator(doubleOperations);
    }


    @Test
    @DisplayName("HappyPath, Operation - Add")
    public void testingAdd() {
        Double result = calculator.add(2.0, 2.0);

        assertEquals(result, 4.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Divide")
    public void testingDivide() {
        Double result = calculator.divide(4.0, 2.0);

        assertEquals(result, 2.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Multiply")
    public void testingMultiply() {
        Double result = calculator.multiply(2.0, 3.0);

        assertEquals(result, 6.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Subtraction")
    public void testingSubtract() {
        Double result = calculator.subtract(6.0, 2.0);

        assertEquals(result, 4.0);
    }
}
