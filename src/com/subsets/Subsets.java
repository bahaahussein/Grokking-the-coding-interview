package com.subsets;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/

medium
 */

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            subsetsHelper(nums, i, new ArrayList<>(), result);
        }
        return result;
    }

    private void subsetsHelper(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        curr.add(nums[i]);
        result.add(new ArrayList<Integer>(curr));
        i++;
        while (i<nums.length) {
            subsetsHelper(nums, i, curr, result);
            i++;
        }
        curr.remove(curr.size()-1);
    }
}
