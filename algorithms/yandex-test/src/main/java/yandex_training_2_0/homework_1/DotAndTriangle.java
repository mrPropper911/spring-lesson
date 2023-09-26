package yandex_training_2_0.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DotAndTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(bufferedReader.readLine());
        String[] strIn = bufferedReader.readLine().split(" ");
        int[] Z = new int[]{Integer.parseInt(strIn[0]), Integer.parseInt(strIn[1])};
        System.out.println(mainLogic(d, Z));
    }

    public static int mainLogic(int d, int []Z){
        int[] A = new int[]{0, 0};
        int[] B = new int[]{d, 0};
        int[] C = new int[]{0, d};

        int a = (A[0] - Z[0]) * (B[1] - A[1]) - (B[0] - A[0]) * (A[1] - Z[1]);
        int b = (B[0] - Z[0]) * (C[1] - B[1]) - (C[0] - B[0]) * (B[1] - Z[1]);
        int c = (C[0] - Z[0]) * (A[1] - C[1]) - (A[0] - C[0]) * (C[1] - Z[1]);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)){
            return 0;
        } else {
            double distAZ = distanceBetweenDot(A[0], A[1], Z[0], Z[1]);
            double distBZ = distanceBetweenDot(B[0], B[1], Z[0], Z[1]);
            double distCZ = distanceBetweenDot(C[0], C[1], Z[0], Z[1]);
            if (distAZ <= distBZ && distAZ <= distCZ){
                return 1;
            } else if (distBZ <= distAZ && distBZ <= distCZ){
                return 2;
            } else {
                return 3;
            }
        }
    }

    public static double distanceBetweenDot(int Xa, int Ya, int Xb, int Yb){
        return Math.sqrt(Math.pow(Xa - Xb, 2) + Math.pow(Ya - Yb, 2));
    }
}
