package yandex_training_2_0.packA.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HardEquation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());
        System.out.println(mainLogic(a, b, c, d));
    }

    //( ax + b ) : ( cx + d ) = 0
    public static String mainLogic(int a, int b, int c, int d){
        if (a == 0 && b == 0){
            return "INF";
        } else if (a == 0 || b * c == d * a){
            return "NO";
        } else if (b % a == 0){
            int x = -b/a;
            return x + "";
        } else {
            return "NO";
        }
    }
}
