package com.intervals;

import java.util.ArrayList;
import java.util.List;


/*
https://leetcode.com/problems/interval-list-intersections/

medium
 */

public class IntervalsIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while(i<firstList.length && j<secondList.length) {
            if(firstList[i][1] < secondList[j][0]) {
                i++;
            } else if(firstList[i][0] > secondList[j][1]) {
                j++;
            } else {
                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                result.add(new int[] { start, end });
                if(firstList[i][1] == end) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
