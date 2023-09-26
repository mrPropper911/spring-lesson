package yandex_back_end_test;

import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int b = scanner.nextInt();
        mainLogic(m, b);
    }

    public static void mainLogic(int firstNumber, int secondNumber){
        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber * secondNumber);
    }
}