package com.two.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindTheMedianOfNumberStream {

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    private Double median;

    /** initialize your data structure here. */
    public FindTheMedianOfNumberStream() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.median = null;
        if(this.maxHeap.isEmpty() || num < this.maxHeap.peek()) {
            this.maxHeap.add(num);
        } else if(num > this.maxHeap.peek()) {
            this.minHeap.add(num);
        } else if(this.maxHeap.size() == this.minHeap.size()) {
            this.maxHeap.add(num);
            return;
        } else {
            this.minHeap.add(num);
            return;
        }

        if(this.maxHeap.size() > this.minHeap.size() + 1) {
            this.minHeap.add(this.maxHeap.remove());
        } else if(this.minHeap.size() > this.maxHeap.size()) {
            this.maxHeap.add(this.minHeap.remove());
        }
    }

    public double findMedian() {
        if(this.median != null)
            return this.median;
        if(this.maxHeap.size() == this.minHeap.size())
            this.median = (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
        else
            this.median = this.maxHeap.peek() * 1.0;
        return this.median;
    }
}
