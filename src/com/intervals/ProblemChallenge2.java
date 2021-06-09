package com.intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ProblemChallenge2 {

    public int maxCpuLoad(int[][] jobs) {
        Arrays.sort(jobs, (x, y) -> x[0] - y[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int curr = 0;
        for(int[] job : jobs) {
            pq.offer(job[1]);
            map.put(job[1], map.getOrDefault(job[1], 0) + job[2]);
            curr += job[2];
            while(!pq.isEmpty() && job[0] >= pq.peek()) {
                curr -= map.get(pq.peek());
                map.put(pq.peek(), 0);
                pq.poll();
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}
