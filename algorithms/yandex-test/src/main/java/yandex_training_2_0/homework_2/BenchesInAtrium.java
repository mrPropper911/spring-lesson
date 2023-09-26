package yandex_training_2_0.homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BenchesInAtrium {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int lengthOfBench = Integer.parseInt(line1[0]);//L
        int countOfBlock = Integer.parseInt(line1[1]);//K
        String[] line2 = bufferedReader.readLine().split(" ");
        int[] arrayOfBlock = new int[countOfBlock];
        for (int i = 0; i < line2.length; i++) {
            arrayOfBlock[i] = Integer.parseInt(line2[i]);
        }
        int[] answer = mainLogic(lengthOfBench, countOfBlock, arrayOfBlock);
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }

    public static int[] mainLogic(int lengthOfBench, int countOfBlock, int[] arrayOfBlock) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index : arrayOfBlock) {
            arrayList.add(index);
        }

        if (lengthOfBench % 2 != 0 && arrayList.contains(lengthOfBench / 2)) {
            return new int[]{lengthOfBench / 2};
        }

        int centreOfBench = lengthOfBench / 2 - 1;
        for (int i = 0; i < arrayOfBlock.length; i++) {
            if (centreOfBench < arrayOfBlock[i]) {
                return new int[]{arrayOfBlock[i - 1], arrayOfBlock[i]};
            }
        }
        return new int[0];
    }
}
