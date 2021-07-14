package com.TopKElements;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private final PriorityQueue<Integer> pq = new PriorityQueue<>();

    private final int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for(int num : nums)
            insert(num);
    }

    public int add(int val) {
        insert(val);
        return this.pq.peek();
    }

    private void insert(int num) {
        if(this.pq.size() < this.k) {
            this.pq.add(num);
        } else if(this.pq.peek() < num) {
            this.pq.remove();
            this.pq.add(num);
        }
    }
}
