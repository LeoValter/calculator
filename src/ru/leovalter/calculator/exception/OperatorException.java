package ru.leovalter.calculator.exception;

public class OperatorException extends RuntimeException {
    public OperatorException() {
        super("Invalid operator entered...");
    }
}
