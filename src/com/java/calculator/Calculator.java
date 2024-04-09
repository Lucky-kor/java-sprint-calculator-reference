package com.java.calculator;
import java.util.Scanner;

public class Calculator {
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
            double leftOperand = input.nextDouble();
            input.nextLine();

            // 2. 연산자의 종류는 +, -, *, / 입니다.
            System.out.println("연산자를 입력해 주세요.");
            String operator = input.nextLine();

            System.out.println("두번째 숫자를 입력해 주세요.");
            double rightOperand = input.nextDouble();
            input.nextLine();

            double result = 0;

            boolean isTrue = true;

            switch (operator) {
                case "+" :
                    result = leftOperand + rightOperand;
//                System.out.println("계산 결과는 : " + result);
                    break;
                case "-" :
                    result = leftOperand - rightOperand;
//                System.out.println("계산 결과는 : " + result);
                    break;
                case "*" :
                    result = leftOperand * rightOperand;
//                System.out.println("계산 결과는 : " + result);
                    break;
                case "/" :
                    result = leftOperand / rightOperand;
//                System.out.println("계산 결과는 : " + result);
                    break;
                default:
                    isTrue = false;
                    break;
            }

            if(isTrue) {
                System.out.println("계산 결과는 : " + result);
            } else {
                System.out.println("잘못된 연산자를 입력했습니다.");
            }

            System.out.println("-".repeat(30));
            System.out.println("다시 계산을 시작할까요? 아니라면 N을 눌러주세요.");
            isNone = input.nextLine().toLowerCase();
        } while (!isNone.equals("n"));

        // TODO...
    }
}