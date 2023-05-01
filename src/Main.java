import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String input = first.replaceAll("\\s+", "");
        String result = calc(input);
        out.println(result);
    }
    public static String calc(String input) throws Exception {
        String[] inp1 = (input.split("[+-/*]"));
        int k = inp1.length;
        if (k != 2) {
            throw new Exception("Проверьте правильность ввода.");
        }
        int operator = oper(input);
        int operand1 = operand(inp1[0]);
        int operand2 = operand(inp1[1]);
        int result = calculator(operand1, operand2, operator);
        return Integer.toString(result);
    }

    static int oper(String in) {
        if (in.contains("+")) {
            return 1;
        }
        if (in.contains("-")) {
            return 2;
        }
        if (in.contains("*")) {
            return 3;
        }
        if (in.contains("/")) {
            return 4;
        }
        return 0;
    }

    static int operand(String i) throws Exception {
        try {
            int operand = Integer.parseInt(i);
            if (operand <= 0 || operand >= 10) {
                throw new Exception();
            }
            return operand;
        } catch (Exception e) {
            throw new Exception("Проверьте правильность ввода.Один из операндов не удовлетворяет условиям.");
        }
    }

    static int calculator(int a, int b, int op) {
        return switch (op) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }
}
