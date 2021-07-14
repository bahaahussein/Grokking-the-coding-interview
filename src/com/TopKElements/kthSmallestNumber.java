package com.TopKElements;

import java.util.PriorityQueue;

public class kthSmallestNumber {

    public Integer kSmallestElement(int[] nums, int k) {
        if(k<=0 || nums.length<k)
            return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++) {
            if(nums[i]<pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.remove();
    }
}
