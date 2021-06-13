package com.cyclic.sort;

public class ProblemChallenge1 {

    public int[] findCorruptNumbers(int[] nums) {
        int[] result = new int[2];
        for(int num : nums) {
            int i = Math.abs(num) - 1;
            if(nums[i] < 0) {
                result[0] = i + 1;
            } else {
                nums[i] = -1 * nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }
}
