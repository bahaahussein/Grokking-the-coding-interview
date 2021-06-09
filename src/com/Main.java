package com;

import com.intervals.ProblemChallenge3;

public class Main {

    public static void main(String[] args) {
        final var solution = new ProblemChallenge3();
        int[][][] schedule = new int[][][] {
                new int[][] { new int[] { 1,3 }, new int[] { 2, 4 } },
                new int[][] { new int[] { 3,5 }, new int[] { 7,9 } }
        };
        final var result = solution.findEmployeeFreeTime(schedule);
        System.out.println("result: " + result);
    }
}
