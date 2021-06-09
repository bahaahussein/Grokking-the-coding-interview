package com.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemChallenge3 {

    public List<int[]> findEmployeeFreeTime(int[][][] schedule) {
        PriorityQueue<EmployeeInterval> pq = new PriorityQueue<>();
        for(int i = 0; i<schedule.length; i++) {
            pq.offer(new EmployeeInterval(schedule[i][0], i, 0));
        }
        List<int[]> result = new ArrayList<>();
        EmployeeInterval prev = pq.peek();
        while (!pq.isEmpty()) {
            EmployeeInterval curr = pq.poll();
            if(curr.interval[0] > prev.interval[1]) {
                result.add(new int[] { prev.interval[1], curr.interval[0] });
                prev = curr;
            } else if(curr.interval[1] > prev.interval[1]) {
                prev = curr;
            }
            if(schedule[curr.employeeIndex].length > curr.intervalIndex + 1) {
                pq.offer(new EmployeeInterval
                        (schedule[curr.employeeIndex][curr.intervalIndex+1], curr.employeeIndex,
                                curr.intervalIndex+1));
            }
        }
        return result;
    }


    private static class EmployeeInterval implements Comparable<EmployeeInterval> {
        private int[] interval;
        private int employeeIndex;
        private int intervalIndex;

        private EmployeeInterval(int[] interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }

        @Override
        public int compareTo(EmployeeInterval o) {
            return this.interval[0] - o.interval[0];
        }
    }
}
