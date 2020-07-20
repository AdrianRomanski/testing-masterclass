package chapter01.generics_calculator.operations;

public interface Operation<T> {

    T calculate(T x, T y);
    String operationName();
}
