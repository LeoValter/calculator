package ru.leovalter.calculator;

import ru.leovalter.calculator.exception.NemeralFormatExctption;
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

    public static String calculator(String input) {
        String[] s = input.split(" ");
        String operandA = s[0], operator = s[1], operandB = s[2];

        String result = "";

        if (checkOperator(operator)) {
            if (checkArabic(operandA) && checkArabic(operandB)) {
                result = String.valueOf(computeArabic(Integer.parseInt(operandA), Integer.parseInt(operandB), operator));
            } else if (!(checkArabic(operandA)) && !(checkArabic(operandB))) {
                result = computeRoman(operandA, operandB, operator);
            } else {
                throw new NemeralFormatExctption();
            }
        } else {
            throw new OperatorException();
        }
        return result;
    }

}