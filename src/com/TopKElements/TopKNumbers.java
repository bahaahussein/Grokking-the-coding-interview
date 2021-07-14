package com.TopKElements;

import java.util.PriorityQueue;

public class TopKNumbers {

    public int[] topKNumbers(int[] numbers, int k) {
        if(k <= 0)
            return new int[0];
        if(numbers.length <= k)
            return numbers;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(numbers[i]);
        }
        for(int i=k; i<numbers.length; i++) {
            if(numbers[i] > pq.peek()) {
                pq.remove();
                pq.add(numbers[i]);
            }
        }
        int[] result = new int[k];
        for(int i=0; i<result.length; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

}
