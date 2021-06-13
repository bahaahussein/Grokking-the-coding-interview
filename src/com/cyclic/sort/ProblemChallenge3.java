package com.cyclic.sort;

import java.util.HashSet;
import java.util.Set;

public class ProblemChallenge3 {

    public int[] firstMissingPositiveNumbers(int[] nums, int k) {
        int[] result = new int[k];
        Set<Integer> existingPositiveNumbers = new HashSet<>();
        for(int num : nums) {
            if(num > 0)
                existingPositiveNumbers.add(num);
        }
        for(int i = 1, j = 0; j < k; i++) {
            if(!existingPositiveNumbers.contains(i)) {
                result[j++] = i;
            }
        }
        return result;
    }
}
