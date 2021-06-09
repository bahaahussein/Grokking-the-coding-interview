package com.two.pointers;

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

medium
 */

public class ProblemChallenge3Important {

    public int findUnsortedSubarray(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<nums.length-1 && nums[lo] <= nums[lo+1])
            lo++;
        if(lo == nums.length-1)
            return 0;
        while(hi>0 && nums[hi] >= nums[hi-1])
            hi--;
        int min = nums[lo];
        int max = nums[lo];
        for(int i=lo+1; i<=hi; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > min) {
                start = i;
                break;
            }
        }
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < max) {
                end = i;
                break;
            }
        }
        return end-start+1;
    }
}
