package com.KWayMerge;

import java.util.*;

public class ProblemChallenge1 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> y.get(0) + y.get(1) - x.get(0) - x.get(1));
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                if(pq.size() < k) {
                    pq.add(List.of(nums1[i], nums2[j]));
                } else {
                    int currSum = nums1[i] + nums2[j];
                    List<Integer> maxResult = pq.peek();
                    if(currSum < maxResult.get(0) + maxResult.get(1)) {
                        pq.remove();
                        pq.add(List.of(nums1[i], nums2[j]));
                    } else
                        break;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.remove());
        }
        return result;
    }
}
