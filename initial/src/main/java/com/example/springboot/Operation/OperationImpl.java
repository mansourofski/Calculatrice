package com.example.springboot.Operation;

public class OperationImpl implements Operation{
    @Override
    public int doSustration(int a, int b) {
        return a-b;
    }

    @Override
    public int doDivision(int a, int b) {
        return a/b;
    }

    @Override
    public int doMultiplication(int a, int b) {
        return a*b;
    }

    @Override
    public int doAddition(int a, int b) {
        return a+b;
    }
}
