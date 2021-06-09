package com.two.pointers;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/

easy
 */

public class SquaringSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int left = -1;
        int right = nums.length;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] >=0) {
                right = i;
                break;
            } else {
                left = i;
            }
        }

        int j = 0;

        while(right<nums.length && left>=0) {
            int ls = nums[left] * nums[left];
            int rs = nums[right] * nums[right];
            if(ls <= rs) {
                result[j] = ls;
                j++;
                left--;
            } else {
                result[j] = rs;
                j++;
                right++;
            }
        }

        while(right<nums.length) {
            result[j] = nums[right] * nums[right];
            j++;
            right++;
        }

        while(left>=0) {
            result[j] = nums[left] * nums[left];
            j++;
            left--;
        }




        return result;
    }
}
