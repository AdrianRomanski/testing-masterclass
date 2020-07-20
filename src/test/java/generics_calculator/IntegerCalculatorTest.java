package generics_calculator;

import chapter01.generics_calculator.factory.IntegerCalculator;
import chapter01.generics_calculator.operations.Operation;
import chapter01.generics_calculator.operations.Operations;
import chapter01.generics_calculator.operations.integer_operations.IntegerAdd;
import chapter01.generics_calculator.operations.integer_operations.IntegerDivide;
import chapter01.generics_calculator.operations.integer_operations.IntegerMultiply;
import chapter01.generics_calculator.operations.integer_operations.IntegerSubtract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerCalculatorTest {

    IntegerCalculator calculator;


    @BeforeEach
    void init() {
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

        calculator = new IntegerCalculator(integerOperations);
    }


    @Test
    @DisplayName("HappyPath, Operation - Add")
    public void testingAdd() {
        Integer result = calculator.add(2, 2);

        assertEquals(result, 4);
    }


    @Test
    @DisplayName("HappyPath, Operation - Divide")
    public void testingDivide() {
        Integer result = calculator.divide(8, 6);

        assertEquals(result, 1);
    }


    @Test
    @DisplayName("HappyPath, Operation - Multiply")
    public void testingMultiply() {
        Integer result = calculator.multiply(2, 3);

        assertEquals(result, 6);
    }


    @Test
    @DisplayName("HappyPath, Operation - Subtraction")
    public void testingSubtract() {
        Integer result = calculator.subtract(6, 2);

        assertEquals(result, 4);
    }
}
