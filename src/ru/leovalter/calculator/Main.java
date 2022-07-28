package ru.leovalter.calculator;

import ru.leovalter.calculator.exception.ExpressionException;
import ru.leovalter.calculator.exception.NumeralFormatExctption;
import ru.leovalter.calculator.exception.OperatorException;

import java.util.Scanner;

import static ru.leovalter.calculator.CalculatorUtil.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(calculator(line));
        scanner.close();
    }

    public static String calculator(String input) throws NumeralFormatExctption, OperatorException {
        String[] strings = input.split(" ");
        if (strings.length > 3) {
            throw new ExpressionException("Incorrect expression... " +
                    "An operation is allowed on two numbers in Roman or Arabic format...");
        }
        String operandA = strings[0], operator = strings[1], operandB = strings[2];

        String result;

        if (checkOperator(operator)) {
            if (checkArabic(operandA) && checkArabic(operandB)) {
                result = String.valueOf(computeArabic(Integer.parseInt(operandA), Integer.parseInt(operandB), operator));
            } else if (!(checkArabic(operandA)) && !(checkArabic(operandB))) {
                result = computeRoman(operandA, operandB, operator);
            } else {
                throw new NumeralFormatExctption();
            }
        } else {
            throw new OperatorException();
        }
        return result;
    }

}