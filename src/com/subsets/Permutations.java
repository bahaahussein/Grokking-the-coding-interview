package com.subsets;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++) {
            permuteHelper(nums, i, new ArrayList<>(), result, new HashSet<>());
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(sb);
        return result;
    }



    private void permuteHelper(int[] nums, int i, List<Integer> curr, List<List<Integer>> result, Set<Integer> set) {
        if(curr.size() == nums.length - 1) {
            result.add(new ArrayList<>(curr) {{add(nums[i]);}});
            return;
        }

        curr.add(nums[i]);
        set.add(i);
        for (int j=0; j<nums.length; j++) {
            if(set.contains(j))
                continue;
            set.add(j);
            permuteHelper(nums, j, curr, result, set);
            set.remove(j);
        }
        curr.remove(curr.size()-1);
        set.remove(i);
    }
}
