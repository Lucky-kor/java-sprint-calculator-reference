package com.java.calculator;
import java.util.Scanner;

public class CalculatorV2 {
    public static void main(String[] args) {
        /*
            요구 사항에 따라 간단한 계산기를 만들어주세요.
            1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            2. 연산자의 종류는 +, -, *, / 입니다.
            3. 소수점 연산을 수행할 수 있어야 합니다.
            4. 연산 결과를 콘솔에 출력합니다.
        */
        System.out.println("===Java Calculator===");

        Scanner input = new Scanner(System.in);

        String isNone = "";
        do {
            // 1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            System.out.println("첫번째 숫자를 입력해 주세요.");
            String leftOperand = input.nextLine();


            // 2. 연산자의 종류는 +, -, *, / 입니다.
            System.out.println("연산자를 입력해 주세요.");
            String operator = input.nextLine();

            System.out.println("두번째 숫자를 입력해 주세요.");
            String rightOperand = input.nextLine();

            // 입력받은 값들이 유효한지 검사합니다.
            if(validate(leftOperand, operator, rightOperand)) {
                // 유효하면 계산을 수행하고 결과를 출력합니다.
                double result = calculate(Double.parseDouble(leftOperand), operator, Double.parseDouble(rightOperand));
                System.out.println("계산 결과 : " + result);
            } else {
                // 유효하지 않으면 오류 메시지를 출력합니다.
                System.out.println("잘못된 수식이 입력되었습니다.");
            }

            // 구분선을 출력합니다.
            System.out.println("-".repeat(30));
            // 사용자가 계속할지 여부를 묻습니다.
            System.out.println("다시 계산을 시작할까요? 아니라면 N을 눌러주세요.");
            isNone = input.nextLine().toLowerCase();
        } while (!isNone.equals("n")); // 사용자가 "n"을 입력할 때까지 반복합니다.
    }

    // 입력받은 숫자와 연산자가 유효한지 검사하는 메서드입니다.
    public static boolean validate(String num1, String op, String num2) {
        // 연산자가 유효한지 검사합니다.
        if(isValidOperator(op)) {
            // 연산자가 나눗셈일 경우, 두 번째 숫자가 0인지 검사합니다.
            if(op.equals("/")) {
                return !isZero(num2);
            }else {
                // 나눗셈이 아닐 경우, 두 숫자 모두 유효한지 검사합니다.
                return isValidDigitString(num1) && isValidDigitString(num2);
            }
        } else {
            return false; // 연산자가 유효하지 않으면 false를 반환합니다.
        }
    }

    // 문자열이 "0"인지 검사하는 메서드입니다.
    public static boolean isZero(String formula) {
        // formula = "1234" -> 순회해서 검증해야 함
        // 문자열에서 각 하나의 문자가 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, . 인지 체크
        // .은 1개 또는 0개여야만 함
        String digit = "0.";
        int dotCount = 0;
        for(char c: formula.toCharArray()) {
            // c = 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, . 아닌지를
            if(digit.indexOf(c) == -1) {
                return false;
            }
            if(c == '.') {
                dotCount++;
            }
        }

        return dotCount <= 1;
    }

    // 문자열이 유효한 숫자인지 검사하는 메서드입니다.
    public static boolean isValidDigitString(String formula) {
        // formula = "1234" -> 순회해서 검증해야 함
        // 문자열에서 각 하나의 문자가 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, . 인지 체크
        // .은 1개 또는 0개여야만 함
        String digit = "1234567890.";
        int dotCount = 0;
        for(char c: formula.toCharArray()) {
            // c = 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, . 아닌지를
            if(digit.indexOf(c) == -1) {
                return false;
            }
            if(c == '.') {
                dotCount++;
            }
        }
        return dotCount <= 1; // "."이 1개 이하면 true, 그렇지 않으면 false를 반환합니다.
    }

    // 연산자가 유효한지 검사하는 메서드입니다.
    public static boolean isValidOperator(String formula) {
        String operators = "+-*/";
        int operatorCount = 0;
        for(char c : formula.toCharArray()) {
            if(operators.indexOf(c) != -1) {
                operatorCount++;
            } else {
                return false;
            }
        }

        return operatorCount == 1; // 연산자가 정확히 하나 있으면 true를 반환합니다.
    }

    // 실제 계산을 수행하는 메서드입니다.
    public static double calculate(double left, String op, double right) {
        // 결과를 저장할 변수입니다.
        double result = 0.0;

        // 연산자에 따라 해당하는 연산을 수행합니다.
        switch (op) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
        }

        return result; // 계산 결과를 반환합니다.
    }
}