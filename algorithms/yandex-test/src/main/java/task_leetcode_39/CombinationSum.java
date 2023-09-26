package task_leetcode_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || candidates[0] > target){
            return res;
        }
        res = recursiv(candidates, target, 0);
        return res;
    }

    private static List<List<Integer>> recursiv(int[] arr, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();

        if(start >= arr.length || arr[start] > target){
            return res;
        }

        if (target == arr[start]){
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[start]);
            res.add(temp);
            return res;
        }

        for (int j = start; j < arr.length; j++){
            if (target == arr[j]){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[j]);
                res.add(temp);
                break;
            }

            List<List<Integer>> temp = recursiv(arr, target - arr[j], j);
            if (!temp.isEmpty()){
                for (List<Integer> index : temp){
                    index.add(0, arr[j]);
                    res.add(index);
                }
            }
        }

        return res;
    }
}

// 2 from 3 test, trouble with [2,3,5] - 8 = [2,2,2,2] [3,5]
// missing [2,3,3]
/*List<List<Integer>> answer = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();

            //check 1 length array
            if (candidates.length == 1 && candidates[0] == target){
                tempList.add(target);
                answer.add(new ArrayList<>(target));
                return answer;
            } else if (candidates.length == 1){
                return answer;
            }

            int temp = 0;
            boolean check = false;
            boolean checkRepeat = false;
            int count = 0;


                for (int i = 0; i < candidates.length; i++) {

                    if (check) {
                        i--;
                        check = false;
                    }

                    temp += candidates[i];
                    if (temp < target) {
                        check = true;
                        tempList.add(candidates[i]);
                    } else if (temp == target) {
                        tempList.add(candidates[i]);
                        answer.add(new ArrayList<>(tempList));
                        tempList.clear();
                        temp = 0;
                        if (checkRepeat) {
                            check = true;
                            checkRepeat = false;
                        }
                    } else {
                        temp = temp - candidates[i] - tempList.get(tempList.size() - 1);
                        tempList.remove(tempList.size() - 1);
                        checkRepeat = true;
                    }
                }

            return answer;*/