package task_a;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) throws IOException {
        TaskA taskA = new TaskA();
        DecimalFormat format = new DecimalFormat("0.#");
        System.out.println(format.format(taskA.mainBalancerCheck()));
    }

    public double mainBalancerCheck() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n <= 0 || n > 100000){
            return -1;
        }

        double[] integerArray = new double[n];
        for (int i = 0; i < n; i++){
            double addV = scanner.nextDouble();
            if ((addV < 1 || addV > Math.pow(10,9)) ||
                    ((i>=1 && integerArray[i-1] > addV)) ||
                    (i>=1 && (addV - integerArray[i-1]) != (int)(addV - integerArray[i-1]))){
                return -1;
            }
            integerArray[i] = addV;
        }

        double countOperationOut = 0;

        countOperationOut = integerArray[n - 1] - integerArray[0];
        if ((int)countOperationOut != countOperationOut){
            return -1;
        }

        return countOperationOut;
    }
}
