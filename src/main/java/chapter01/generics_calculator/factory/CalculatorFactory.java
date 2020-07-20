package chapter01.generics_calculator.factory;

public interface CalculatorFactory<T> {

    T add(T x, T y);
    T subtract(T x, T y);
    T divide(T x, T y);
    T multiply(T x, T y);
}
