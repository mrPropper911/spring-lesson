package yandex_training_2_0.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interactor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int r;//taskCompletionCode
        int i;//verdictInteractor
        int c;//verdictChecker
        r = Integer.parseInt(bufferedReader.readLine());
        i = Integer.parseInt(bufferedReader.readLine());
        c = Integer.parseInt(bufferedReader.readLine());
        System.out.println(mainLogic(r, i, c));
    }

    public static int mainLogic (int taskCompletionCode, int verdictInteractor, int verdictChecker){
        int answer;
        switch (verdictInteractor){
            case (0) :
                if (taskCompletionCode != 0){
                    return 3;
                } else {
                    return verdictChecker;
                }
            case (1) :
                return verdictChecker;
            case (4):
                if (taskCompletionCode != 0){
                    return 3;
                } else {
                    return 4;
                }
            case (6):
                return 0;
            case (7):
                return 1;
            default:
                answer = verdictInteractor;
        }
        return answer;
    }
}
