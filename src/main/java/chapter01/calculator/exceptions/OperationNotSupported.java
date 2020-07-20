package chapter01.calculator.exceptions;

public class OperationNotSupported extends RuntimeException{

    public OperationNotSupported(String operationName) {
        super(operationName + " Operation not supported");
    }
}
