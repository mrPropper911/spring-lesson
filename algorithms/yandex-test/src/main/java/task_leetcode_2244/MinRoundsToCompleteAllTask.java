package task_leetcode_2244;

import java.util.HashMap;
import java.util.Map;

public class MinRoundsToCompleteAllTask {
    public static void main(String[] args) {

    }

    public static int minimumRounds(int[] tasks) {
        //Initial check
        if (tasks.length == 0) {
            return -1;
        }
        //Main variables
        int answer = 0;
        HashMap<Integer, Integer> mapOfNumber = new HashMap<>();
        //Search for identical values
//        HashSet<Integer> setOfCount = new HashSet<>();
        for (int task : tasks) {
            mapOfNumber.put(task, mapOfNumber.getOrDefault(task, 0) + 1);
//            if(!mapOfNumber.containsKey(task)){
//               mapOfNumber.put(task, 1);
//            } else {
//                mapOfNumber.put(task, mapOfNumber.get(task)+1);
//            }

//            if (setOfCount.contains(task)) {
//                mapOfNumber.put(task, mapOfNumber.get(task) + 1);
//            } else {
//                mapOfNumber.put(task, 1); // init map
//                setOfCount.add(task);
//            }
        }
        //Main logic #1
        for (Map.Entry<Integer, Integer> entry : mapOfNumber.entrySet()) {
            int tempInt = countOfRounds(entry.getValue());
            if (tempInt > 0) {
                answer += tempInt;
            } else {
                return -1;
            }
        }
        return answer;
    }

    //Main logic #1
    public static int countOfRounds(int countOnHashMap) {
        int answer = 0;

        while (countOnHashMap != 0) {
            answer++;

            //only in first try check
            if ((countOnHashMap - 3) < 0 && (countOnHashMap - 2) < 0 && answer == 1) {
                return -1;
            }

            if ((countOnHashMap - 3) == 0) {
                return answer;
            }

            if ((countOnHashMap - 2) == 0) {
                return answer;
            }

            if ((countOnHashMap - 3) == 1) {
                countOnHashMap -= 2;
                continue;
            }

            if ((countOnHashMap - 3) >= 1) {
                countOnHashMap -= 3;
            } else {
                countOnHashMap -= 2;
            }
        }

        return answer;
    }


}
