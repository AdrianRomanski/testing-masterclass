package chapter01;

import chapter01.SimpleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    SimpleCalculator calculator;

    @Test
    void shouldReturnANumberWhenNumberGiven() {
        getCalculator();
        assertEquals(2, calculator.add("2"));
    }

    @Test
    void shouldReturnSumTwoNumbersWhenTwoNumbersGiven() {
        getCalculator();
        assertEquals(3, calculator.add("2,1"));
    }

    private void getCalculator() {
        calculator = new SimpleCalculator();
    }

}