import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Каким калькулятором хотите воспользовать? \n  1.Арабский  \n  2.Римский \n Введите номер:");
        String calculation = scanner.nextLine();
        System.out.println("Ввести первое значение");
        String numberOne = scanner.nextLine();
        System.out.println("Ввести второе значение");
        String numberTwo = scanner.nextLine();
        System.out.println("Введите оператор");
        String operator = scanner.nextLine();
        int result;
        int a = 0;
        int b = 0;
        try {
            if (calculation.equals("1")) {
                a = Integer.parseInt(numberOne);
                b = Integer.parseInt(numberTwo);
            }
            if (calculation.equals("2")) {
                a = romanInt(numberOne);
                b = romanInt(numberTwo);
            }
            switch (operator) {
                case ("+"):
                    result = a + b;
                    System.out.println(result);
                    break;
                case ("-"):
                    result = a - b;
                    System.out.println(result);
                    break;
                case ("/"):
                    result = a / b;
                    System.out.println(result);
                    break;
                case ("*"):
                    result = a * b;
                    System.out.println(result);
                    break;
            }
        } catch (Exception I) {
            System.out.println("Введенено не верное значение");
        }
    }
    public static int romanInt(String s) {
        int output = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        if (s.length() == 0) return 0;
        if (s.length() == 1) return map.get(String.valueOf(s.charAt(0)));

        for (int i = 0; i < (s.length() - 1); i++) {
            if (map.get(String.valueOf(s.charAt(i))) >=
                    map.get(String.valueOf(s.charAt(i + 1)))) {
                output = output + map.get(String.valueOf(s.charAt(i)));
            } else {
                output = output - map.get(String.valueOf(s.charAt(i)));
            }

        }
        output = output + map.get(String.valueOf(s.charAt(s.length() - 1)));
        return output;

    }


}