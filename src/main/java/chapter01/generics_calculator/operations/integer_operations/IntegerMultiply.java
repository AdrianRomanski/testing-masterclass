package chapter01.generics_calculator.operations.integer_operations;

import chapter01.generics_calculator.operations.Operation;

public class IntegerMultiply implements Operation<Integer> {

    @Override
    public Integer calculate(Integer x, Integer y) {
        return x * y;
    }

    @Override
    public String operationName() {
        return "Multiply";
    }
}
