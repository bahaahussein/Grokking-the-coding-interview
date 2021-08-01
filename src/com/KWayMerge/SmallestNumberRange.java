package com.KWayMerge;

/*
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

hard
 */

import java.util.*;

public class SmallestNumberRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums.size() == 1)
            return new int[] { nums.get(0).get(0), nums.get(0).get(0) };
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> nums.get(x[0]).get(x[1]) - nums.get(y[0]).get(y[1]));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++) {
            pq.add(new int[] { i, 0 });
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] currMin = pq.peek();
        int[] result = new int[] { nums.get(currMin[0]).get(currMin[1]), max };
        while(true) {
            currMin = pq.remove();
            if(max - nums.get(currMin[0]).get(currMin[1]) < result[1] - result[0]) {
                result[0] = nums.get(currMin[0]).get(currMin[1]);
                result[1] = max;
            }
            if(currMin[1] + 1 < nums.get(currMin[0]).size()) {
                max = Math.max(max, nums.get(currMin[0]).get(currMin[1] + 1));
                pq.add(new int[] { currMin[0], currMin[1] + 1 });
            } else {
                return result;
            }
        }
    }
}
