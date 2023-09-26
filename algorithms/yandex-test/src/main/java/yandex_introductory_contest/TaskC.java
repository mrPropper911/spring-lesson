package yandex_introductory_contest;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(sum(m, b));
    }

    private static int sum(int a, int b){
        return a+b;
    }
}
