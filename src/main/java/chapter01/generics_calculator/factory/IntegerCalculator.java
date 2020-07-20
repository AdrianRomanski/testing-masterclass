package chapter01.generics_calculator.factory;

import chapter01.generics_calculator.operations.Operations;

public class IntegerCalculator implements CalculatorFactory<Integer>{

    private final Operations<Integer> operations;

    public IntegerCalculator(Operations<Integer> operations) {
        this.operations = operations;
    }

    @Override
    public Integer add(Integer x, Integer y) {
        return operations.add(x, y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return operations.subtract(x, y);
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        return operations.divide(x, y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return operations.multiply(x, y);
    }
}
