package task_leetcode_3;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1_1 = {1,2};
        int[] nums2_1 = {3,4};
        System.out.println((findMedianSortedArrays(nums1_1, nums2_1))+ "");

        int[] nums1  = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2) + "");

        int[] nums1_3  = {1,3};
        int[] nums2_3 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2) + "");


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int nums1Count = 0;
        int nums2Count = 0;
        boolean nums1CheckEnd = true;
        boolean nums2CheckEnd = true;
        if (nums1.length == 0){
            nums1CheckEnd = false;
        }
        if (nums2.length == 0){
            nums2CheckEnd = false;
        }

        for (int i = 0; i < nums3.length; i++){
            if( nums1CheckEnd && nums2CheckEnd && (nums1[nums1Count] < nums2[nums2Count])){
                nums3[i] = nums1[nums1Count];
                if (nums1Count < (nums1.length - 1)){
                    nums1Count++;
                } else {
                    nums1CheckEnd = false;
                }
            } else if (!nums1CheckEnd){
                nums3[i] = nums2[nums2Count];
                if (nums2Count < (nums2.length - 1)){
                    nums2Count++;
                }

            } else if (!nums2CheckEnd){
                nums3[i] = nums1[nums1Count];
                if (nums1Count < (nums1.length - 1)){
                    nums1Count++;
                }
            }
            else {
                nums3[i] = nums2[nums2Count];
                if (nums2Count < (nums2.length - 1)){
                    nums2Count++;
                } else {
                    nums2CheckEnd = false;
                }
            }
        }

        if (nums3.length % 2 != 0){
            return nums3[nums3.length/2];
        } else {
            return  (nums3[nums3.length/2-1] + nums3[nums3.length/2])/2.0;
        }
    }
}
