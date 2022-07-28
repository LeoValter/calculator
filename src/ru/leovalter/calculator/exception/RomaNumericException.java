package ru.leovalter.calculator.exception;

public class RomaNumericException extends RuntimeException {
    public RomaNumericException(String romaNum) {
        super("Invalid roman numeral entered: " + romaNum);
    }
}
