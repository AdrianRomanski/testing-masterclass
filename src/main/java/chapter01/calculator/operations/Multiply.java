package chapter01.calculator.operations;

public class Multiply implements Operation{

    private final String name;

    public Multiply() {
        this.name = this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public Double calculate(Double x, Double y) {
        return x * y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return " x * y";
    }
}
