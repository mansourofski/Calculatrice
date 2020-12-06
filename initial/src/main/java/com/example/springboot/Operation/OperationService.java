package com.example.springboot.Operation;

public class OperationService {
    public static int doOperation(OperationDTO operationDTO)
    {
        Operation operation = new OperationImpl();
        switch (operationDTO.getOperation().toLowerCase()) {
            case "addition":
                return operation.doAddition(operationDTO.getLeft(), operationDTO.getRight());
            case "sustraction":
                return operation.doSustration(operationDTO.getLeft(), operationDTO.getRight());
            case "multiplication":
                return operation.doMultiplication(operationDTO.getLeft(), operationDTO.getRight());
            case "division":
                return operation.doDivision(operationDTO.getLeft(), operationDTO.getRight());
            default: return 0;
        }
    }
}
