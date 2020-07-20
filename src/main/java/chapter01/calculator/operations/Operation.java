package chapter01.calculator.operations;

public interface Operation {

    Double calculate(Double x, Double y);
    String getName();
    String toString();
}
