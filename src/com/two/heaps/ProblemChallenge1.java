package com.two.heaps;

import java.util.PriorityQueue;

public class ProblemChallenge1 {

    public int[] findRightInterval(int[][] intervals) {
        int N = intervals.length;
        int[] result = new int[N];
        for(int i=0; i<N; i++) result[i] = -1;
        PriorityQueue<Interval> minEnd = new PriorityQueue<>((x, y) -> x.end - y.end);
        PriorityQueue<Interval> minStart = new PriorityQueue<>((x, y) -> x.start - y.start);
        for(int i=0; i<N; i++) {
            Interval interval = new Interval(intervals[i][0], intervals[i][1], i);
            minEnd.add(interval);
            minStart.add(interval);
        }
        while(!minEnd.isEmpty()) {
            Interval interval = minEnd.remove();
            while(!minStart.isEmpty() && minStart.peek().start<interval.end)
                minStart.remove();
            if(minStart.isEmpty())
                return result;
            result[interval.index] = minStart.peek().index;
        }

        return result;
    }
}

class Interval {
    int start;

    int end;

    int index;

    Interval(int start, int end, int i) {
        this.start = start;
        this.end = end;
        this.index = i;
    }
}
