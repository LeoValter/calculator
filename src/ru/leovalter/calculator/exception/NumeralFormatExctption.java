package ru.leovalter.calculator.exception;

public class NumeralFormatExctption extends RuntimeException {
    public NumeralFormatExctption() {
        super("Numbers must be in the same format...");
    }

    public NumeralFormatExctption(String message) {
        super("Numbers must be in the same format..." + message);
    }
}
