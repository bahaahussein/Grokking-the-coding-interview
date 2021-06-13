package com.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if(nums[j] > 0) {
                nums[j] = -1 * nums[j];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
