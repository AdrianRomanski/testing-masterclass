package chapter01.generics_calculator.operations;

import chapter01.generics_calculator.exceptions.OperationMissingException;

import java.util.HashMap;
import java.util.Optional;

public class Operations<T> {

    public static final String ADD = "add";
    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String SUBTRACT = "subtract";

    Operation<T> add;
    Operation<T> multiply;
    Operation<T> divide;
    Operation<T> subtract;

    public Operations(HashMap<String, Operation<T>> operations) {
        this.add = Optional.ofNullable(operations.get(ADD)).orElseThrow(() -> new OperationMissingException(ADD));
        this.multiply = Optional.ofNullable(operations.get(MULTIPLY)).orElseThrow(() -> new OperationMissingException(MULTIPLY));
        this.divide = Optional.ofNullable(operations.get(DIVIDE)).orElseThrow(() -> new OperationMissingException(DIVIDE));
        this.subtract = Optional.ofNullable(operations.get(SUBTRACT)).orElseThrow(() -> new OperationMissingException(SUBTRACT));
    }

    public T add(T x, T y) {
        return add.calculate(x,y);
    }

    public T subtract(T x, T y) {
        return subtract.calculate(x, y);
    }

    public T multiply(T x, T y) {
        return multiply.calculate(x, y);
    }

    public T divide(T x, T y) {
        return divide.calculate(x,y);
    }
}
