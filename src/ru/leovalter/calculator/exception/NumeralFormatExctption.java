package ru.leovalter.calculator.exception;

public class NemeralFormatExctption extends RuntimeException {
    public NemeralFormatExctption() {
        super("Numbers must be in the same format...");
    }
}
