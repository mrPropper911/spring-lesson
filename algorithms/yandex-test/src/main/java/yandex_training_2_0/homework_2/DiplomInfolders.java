package yandex_training_2_0.homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiplomInfolders {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countOfFolders = Integer.parseInt(bufferedReader.readLine());
        String[] strIn = bufferedReader.readLine().split(" ");
        int[] countOfDiplomArray = new int[countOfFolders];
        for (int i = 0; i < strIn.length; i++) {
            countOfDiplomArray[i] = Integer.parseInt(strIn[i]);
        }
        System.out.println(mainLogic(countOfFolders, countOfDiplomArray));
    }

    public static int mainLogic(int countOfFolders, int[] countDiplomInFolders) {
        int badSolution = 0;
        Arrays.sort(countDiplomInFolders);
        for (int i = 0; i < countDiplomInFolders.length - 1; i++) {
            badSolution += countDiplomInFolders[i];
        }
        return badSolution;
    }

}
