package com.TopKElements;

import java.util.*;

/*
https://leetcode.com/problems/task-scheduler/

hard
 */

public class ProblemChallenge2 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(entry.getValue());
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        while(!pq.isEmpty()) {
            int i = 0;
            for(; i<=n && !pq.isEmpty(); i++) {
                int f = pq.remove();
                f--;
                if(f>0)
                    q.add(f);
            }
            if(pq.isEmpty() && q.isEmpty()) {
                result += i;
                return result;
            }
            while(!q.isEmpty()) {
                pq.add(q.remove());
            }
            result += n + 1;
        }
        return result;
    }
}
