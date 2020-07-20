package chapter01.calculator.client;

import chapter01.calculator.operations.Operation;
import chapter01.calculator.exceptions.OperationNotSupported;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private final HashMap<String, Operation> operations;

    public Calculator() {
        this.operations = new HashMap<>();
    }


    public void addOperation(Operation operation) {
        this.operations.put(operation.getName(), operation);
    }

    public void addOperations(List<Operation> operationsToAdd) {
        for(Operation operation : operationsToAdd) {
            this.operations.put(operation.getName(), operation);
        }
    }

    public Operation getOperation(String operationName) {
        return Optional.ofNullable(operations.get(operationName.toLowerCase()))
                .orElseThrow(() -> new OperationNotSupported(operationName));
    }

    public HashMap<String, Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "Calculator with " + operations.size() + " Operations: "  + "\n" +
                "Operations = " + operations;
    }
}
