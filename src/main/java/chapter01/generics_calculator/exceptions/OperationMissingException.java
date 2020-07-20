package chapter01.generics_calculator.exceptions;

public class OperationMissingException extends RuntimeException{

    public OperationMissingException(String operationName) {
        super(operationName + " is missing");
    }
}
