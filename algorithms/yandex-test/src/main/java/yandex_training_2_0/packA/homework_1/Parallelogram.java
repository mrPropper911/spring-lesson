package yandex_training_2_0.packA.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//test 8 RE error
public class Parallelogram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());//count of question
        if (N == 0){
            System.out.println("NO");
        }

        for (int i = 0; i < N; i++){
            String[] strIn = bufferedReader.readLine().split(" ");
            int[] intIn = new int[strIn.length];
            for (int j = 0; j < strIn.length; j++){
                intIn[j] = Integer.parseInt(strIn[j]);
            }
            System.out.println(mainLogic(intIn));
        }
    }

    public static String mainLogic(int[] arrIn){
        int[] A = new int[]{arrIn[0], arrIn[1]};
        int[] B = new int[]{arrIn[4], arrIn[5]};
        int[] C = new int[]{arrIn[2], arrIn[3]};
        int[] D = new int[]{arrIn[6], arrIn[7]};

        if (checkMainLogic(A[0], A[1], B[0], B[1], C[0], C[1], D[0], D[1])){
            return "YES";
        } else if (checkMainLogic(B[0], B[1], A[0], A[1], C[0], C[1], D[0], D[1])) {
            return "YES";
        } else if (checkMainLogic(B[0], B[1],  C[0], C[1], A[0], A[1], D[0], D[1])) {
            return "YES";
        } else if (checkMainLogic(B[0], B[1],  C[0], C[1], D[0], D[1], A[0], A[1])) {
            return "YES";
        } else if (checkMainLogic(C[0], C[1], B[0], B[1], D[0], D[1], A[0], A[1])) {
            return "YES";
        } else if (checkMainLogic(B[0], B[1], C[0], C[1], D[0], D[1], A[0], A[1])) {
            return "YES";
        }else {
            return "NO";
        }

    }

    public static boolean checkMainLogic(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3 ){
        double l1 = (Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
        double l2 = (Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        if ((y - y1) == 0 && (y2 - y3) == 0){
            return l1 == l2;
        }
        if ((y - y1) == 0 || (y2 - y3) == 0){
            return false;
        }

        int k1 = (x - x1) / (y - y1);
        int k2 = (x2 - x3) / (y2 - y3);

        return l1 == l2 && k1 == k2;
    }

}
