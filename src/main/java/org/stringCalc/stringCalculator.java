package org.stringCalc;

import java.util.*;

public class stringCalculator {

    public static String add(String number) {
        List<String> errors = new ArrayList<>();

        if ("".equals(number)) {
            return "0";
        } else {
            if (number.startsWith("//")) {
                int newLineIndex = number.indexOf("\n");
                String customDelimiter = number.substring(2, newLineIndex).trim();
                if (customDelimiter.equals("|")) {
                    customDelimiter = "\\|";
                }
                String numberPart = number.substring(newLineIndex + 1).trim();

                if (numberPart.contains(",") && !customDelimiter.equals(",")) {
                    return continousDelimiterError(numberPart);
                }

                return getAnswerString(numberPart, customDelimiter, errors);
            }

            if (number.contains(",\n")) {
                return continousDelimiterError(number);
            }

            if (number.charAt(number.length() - 1) == ',') {
                return EOFErrorMessage();
            }
            else {
                return getAnswerString(number, "[,\n]+", errors);
            }
        }
    }

    private static String getAnswerString(String numberPart, String customDelimiter, List<String> errors) {
        List<Float> negativeNums = new ArrayList<>();
        float answer = 0;
        boolean hasErrors = false;

        String[] values = numberPart.split(customDelimiter);
        for (String value : values) {
            if (!value.isEmpty()) {
                try {
                    Float num = Float.parseFloat(value);
                    if (num > 0) {
                        answer += num;
                    } else {
                        negativeNums.add(num);
                        hasErrors = true;
                    }
                } catch (NumberFormatException e) {
                    errors.add("Number expected but '" + value + "' found at position " + (numberPart.indexOf(value) + 1));
                }
            }
        }

        if (!negativeNums.isEmpty()) {
            errors.add("Negative not allowed: " + negativeNums.toString().replace("[", "").replace("]", "").replace(" ", ""));
            hasErrors = true;
        }

        if (hasErrors) {
            return String.join("\n", errors);
        } else {
            return String.format("%.1f", answer);
        }
    }

    protected static String EOFErrorMessage() {
        return "Number expected but EOF found";
    }

    protected static String continousDelimiterError(String numberPart) {
        int index = numberPart.indexOf(",");
        char foundChar = numberPart.charAt(index);
        return "Number expected but '" + foundChar + "' found at position " + index;
    }

    public static void main(String[] args) {
        String ans = add("//|\n1|2|3");
        System.out.println(ans);
    }
}
