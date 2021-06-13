package com.cyclic.sort;

/*
https://leetcode.com/problems/first-missing-positive/

Hard
 */

public class ProblemChallenge2 {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int num = nums[i];
            int j = num - 1;
            if(num <= 0 || num > nums.length || nums[i] == nums[j]) {
                i++;
            } else {
                int temp = nums[j];
                nums[j] = num;
                nums[i] = temp;
            }
        }
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
