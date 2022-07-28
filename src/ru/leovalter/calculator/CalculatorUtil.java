package ru.leovalter.calculator;

import ru.leovalter.calculator.exception.RangeNumberException;
import ru.leovalter.calculator.exception.RomaNumericException;

import java.util.HashMap;
import java.util.Map;

class CalculatorUtil {

    public static final Map<Integer, String> romans = new HashMap<>();

    static {
        romans.put(0, "N");
        romans.put(1, "I");
        romans.put(2, "II");
        romans.put(3, "III");
        romans.put(4, "IV");
        romans.put(5, "V");
        romans.put(6, "VI");
        romans.put(7, "VII");
        romans.put(8, "VIII");
        romans.put(9, "IX");
        romans.put(10, "X");
        romans.put(20, "XX");
        romans.put(30, "XXX");
        romans.put(40, "XL");
        romans.put(50, "L");
        romans.put(60, "LX");
        romans.put(70, "LXX");
        romans.put(80, "LXXX");
        romans.put(90, "XC");
        romans.put(100, "C");
    }


    private static Integer romaToArabic(String roma) throws RomaNumericException {
        for (int i = 1; i <= 10; ++i) {
            if (romans.get(i).equals(roma)) {
                return i;
            }
        }
        throw new RomaNumericException(roma);
    }

    private static String arabicToRoma(Integer number) {
        StringBuilder result = new StringBuilder();
        if (number < 1) {
            return romans.get(0);
        } else if (number > 10) {
            result.append(romans.get((number / 10) * 10));
            if ((number % 10) != 0) result.append(romans.get(number % 10));
            return result.toString();
        }
        return romans.get(number);
    }

    static String computeRoman(String operandA, String operandB, String operator) {
        Integer integer = computeArabic(romaToArabic(operandA), romaToArabic(operandB), operator);
        return arabicToRoma(integer);
    }

    static int computeArabic(int operandA, int operandB, String operator) {
        checkRange(operandA);
        checkRange(operandB);
        int result = -1;
        switch (operator) {
            case "+" -> result = operandA + operandB;
            case "-" -> result = operandA - operandB;
            case "*" -> result = operandA * operandB;
            case "/" -> {
                if (operandB != 0) {
                    result = (operandA / operandB);
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }

    private static void checkRange(int number) throws RangeNumberException {
        if (!(number > 0 && number < 11)) {
            throw new RangeNumberException("Valid numbers range from 1 to 10");
        }
    }

    static boolean checkArabic(String str) {
        return str.matches("\\d");
    }

    static boolean checkOperator(String operator) {
        return operator.matches("[+\\-/*]");
    }
}
