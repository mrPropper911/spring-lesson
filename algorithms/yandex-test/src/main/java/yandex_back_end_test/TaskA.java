package yandex_back_end_test;

import java.util.Scanner;

public class TaskA {
    static final String RESET = "RESET";
    static final String DISABLE = "DISABLE";
    static final String GETMAX = "GETMAX";
    static final String GETMIN = "GETMIN";

    static int n;//count of data centre
    static int m;//count of servers
    static int q;//count of events

    static int[][] allDateCenter;
    static int[] R;//reset data center info

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] arr1 = s1.split(" ");

        n = Integer.parseInt(arr1[0]);
        m = Integer.parseInt(arr1[1]);
        q = Integer.parseInt(arr1[2]);

        //Init data center
        allDateCenter = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                allDateCenter[i][j] = 1;
            }
        }

        //Init count of reset data center
        R = new int[n];
        for (int i = 0; i < n; i++){
            R[i] = 0;
        }

        for (int i = 0; i < q; i++){
            String line = scanner.nextLine();
            String[] lineOfString = line.split(" ");

            if (lineOfString[0].equals(RESET)){
                reset(Integer.parseInt(lineOfString[1]));
            } else if(lineOfString[0].equals(DISABLE)) {
                disable(Integer.parseInt(lineOfString[1]),Integer.parseInt(lineOfString[2]));
            } else if (lineOfString[0].equals(GETMAX)) {
                System.out.println(getMax());
            } else if (lineOfString[0].equals(GETMIN)) {
                System.out.println(getMin());
            }
        }
    }

    public static void reset(int numberOfDataCenter){
        int indexOfDataCenter = numberOfDataCenter - 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((indexOfDataCenter == i)){
                    allDateCenter[i][j] = 1;
                }
            }
        }
        R[indexOfDataCenter]++;
    }

    public static void disable(int numberOfDataCenter, int numberOfServer){
        int indexOfDataCenter = numberOfDataCenter - 1;
        int indexOfServer = numberOfServer - 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((indexOfDataCenter == i) && (indexOfServer == j)){
                    allDateCenter[i][j] = 0;
                }
            }
        }
    }

    public static int getMax(){
        int[] allDataCenterInfo = new int[n];

        for (int i = 0; i < n; i++){
            int A = 0;
            for (int j = 0; j < m; j++){
               if (allDateCenter[i][j] == 1){
                   A++;
               }
            }
            allDataCenterInfo[i] = R[i] * A;
        }
        int indexReturn = 1;
        int max = allDataCenterInfo[0];
        for (int i = 1; i < n; i++){
            if (allDataCenterInfo[i] > max){
                indexReturn = i + 1;
                max = allDataCenterInfo[i];
            }
        }
        return indexReturn;
    }

    public static int getMin(){
        int[] allDataCenterInfo = new int[n];

        for (int i = 0; i < n; i++){
            int A = 0;
            for (int j = 0; j < m; j++){
                if (allDateCenter[i][j] == 1){
                    A++;
                }
            }
            allDataCenterInfo[i] = R[i] * A;
        }
        int indexReturn = 1;
        int min = allDataCenterInfo[0];
        for (int i = 1; i < n; i++){
            if (allDataCenterInfo[i] < min){
                indexReturn = i + 1;
                min = allDataCenterInfo[i];
            }
        }
        return indexReturn;
    }
}
