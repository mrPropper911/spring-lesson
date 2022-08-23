package task_leetcode_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumClosest {
    public static void main(String[] args) {

        System.out.println(threeSumClosest2(new int[]{-1,2,1,-4}, 1) + " - 2");
        System.out.println(threeSumClosest2(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2) + " - 2");

        System.out.println(threeSumClosest2(new int[]{1,1,1,1}, 0) + " - 3");
        System.out.println(threeSumClosest2(new int[]{1,1,1,0}, -100) + " - 2");

        System.out.println(threeSumClosest2(new int[]{0,0,0}, 1) + " - 0");
    }

    public static int threeSumClosest2(int[] nums, int target){
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] - Math.abs(target);
        }

        Arrays.sort(nums);

        return result;

    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        List<Integer> integerList = new ArrayList<>();

        //searching sum of 3 numbers
        for (int j = 0; j <= (nums.length - 3); j++){
            for (int i = j; i < 3 + j; i++){
                result += nums[i];
            }
            integerList.add(result);
            result = 0;
        }

        //searching minimal
        int minimalBetwen = Math.abs(integerList.get(0) - target);
        int answer = integerList.get(0);
        for (Integer index : integerList){
            if (Math.abs(index - target)< minimalBetwen){
                answer = index;
            }
        }

        return answer;
    }
}
