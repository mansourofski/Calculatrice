package com.example.springboot.Operation;

import java.util.Date;

public class OperationDTO {
    private String operationId;
    private String operation;
    private int left;
    private int right;
    private Date executionDate;
    private int result;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
