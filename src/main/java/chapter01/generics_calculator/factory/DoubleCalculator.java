package chapter01.generics_calculator.factory;

import chapter01.generics_calculator.operations.Operations;

public class DoubleCalculator implements CalculatorFactory<Double>{

    private final Operations<Double> operations;

    public DoubleCalculator(Operations<Double> operations) {
        this.operations = operations;
    }

    @Override
    public Double add(Double x, Double y) { return operations.add(x, y); }

    @Override
    public Double subtract(Double x, Double y) { return operations.subtract(x, y); }

    @Override
    public Double divide(Double x, Double y) { return operations.divide(x, y); }

    @Override
    public Double multiply(Double x, Double y) { return operations.multiply(x, y); }
}
