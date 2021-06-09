package com.two.pointers;

/*
https://leetcode.com/problems/3sum/

medium
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k = nums.length-1;
            while(j<k) {
                int x = nums[i] + nums[j] + nums[k];
                if(x > 0) {
                    k--;
                } else if(x < 0) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    while(j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                    j++;
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
