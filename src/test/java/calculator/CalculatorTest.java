package calculator;

import chapter01.calculator.client.Calculator;
import chapter01.calculator.exceptions.OperationNotSupported;
import chapter01.calculator.operations.Add;
import chapter01.calculator.operations.Divide;
import chapter01.calculator.operations.Multiply;
import chapter01.calculator.operations.Subtraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void before() {
        calculator = new Calculator();
        Add add = new Add();
        Divide divide = new Divide();
        Multiply multiply = new Multiply();
        Subtraction subtraction = new Subtraction();
        calculator.addOperations(Arrays.asList(add, divide, multiply, subtraction));
    }


    @Test
    @DisplayName("HappyPath, Operation - Add")
    public void testingAdd() {
        Double result = calculator.getOperation("Add").calculate(2.0, 2.0);

        assertEquals(result, 4.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Divide")
    public void testingDivide() {
        Double result = calculator.getOperation("Divide").calculate(4.0, 2.0);

        assertEquals(result, 2.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Multiply")
    public void testingMultiply() {
        Double result = calculator.getOperation("Multiply").calculate(2.0, 3.0);

        assertEquals(result, 6.0);
    }


    @Test
    @DisplayName("HappyPath, Operation - Subtraction")
    public void testingSubtract() {
        Double result = calculator.getOperation("Subtraction").calculate(6.0, 2.0);

        assertEquals(result, 4.0);
    }


    @Test
    @DisplayName("UnHappyPath, Adding Duplicate Operation")
    public void testingHashMap() {
        int size = calculator.getOperations().size(); // I rather to have it in variable, so i dont have to change it anymore if more operations added

        Add add2 = new Add();
        calculator.addOperation(add2);

        assertEquals(calculator.getOperations().size(), size); // Checking if there is still 4 Operations
    }


    @Test
    @DisplayName("UnHappyPath, Method = getOperation(), Reason - Wrong Operation Name")
    public void testingGetOperationMethodUnhappyPath() {
        Throwable ex = catchThrowable(() -> calculator.getOperation("Pepperoni Pizza"));

        assertThat(ex).isInstanceOf(OperationNotSupported.class);
    }
}
