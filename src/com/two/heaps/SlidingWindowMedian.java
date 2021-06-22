package com.two.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        for(; i<k; i++) {
            addNum(nums[i], maxHeap, minHeap);
        }
        for(int j=0; j<result.length-1; j++) {
            result[j] = calculateMedian(maxHeap, minHeap);
            removeNum(nums[i-k], maxHeap, minHeap);
            addNum(nums[i], maxHeap, minHeap);
            i++;
        }
        result[result.length-1] = calculateMedian(maxHeap, minHeap);
        return result;
    }

    private double calculateMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size())
            return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
        else
            return minHeap.peek() * 1.0;
    }

    private void addNum(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(minHeap.isEmpty() || num >= minHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);
        balanceHeaps(maxHeap, minHeap);
    }

    private void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(minHeap.size() > maxHeap.size() + 1)
            maxHeap.add(minHeap.remove());
        else if(maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.remove());
    }

    private void removeNum(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(num >= minHeap.peek())
            minHeap.remove(num);
        else
            maxHeap.remove(num);
        balanceHeaps(maxHeap, minHeap);
    }
}
