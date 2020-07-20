package chapter01.generics_calculator.operations.double_operations;

import chapter01.generics_calculator.operations.Operation;

public class DoubleSubtract implements Operation<Double> {

    @Override
    public Double calculate(Double x, Double y) {
        return x - y;
    }

    @Override
    public String operationName() {
        return "Subtract";
    }
}
