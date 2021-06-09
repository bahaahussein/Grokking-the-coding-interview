package com.intervals;

/*
https://leetcode.com/problems/insert-interval/

medium
 */

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int startMerge = Integer.MAX_VALUE;
        int endMerge = -1;
        for(int i=0; i<intervals.length; i++) {
            int[] interval = intervals[i];
            int as = interval[0];
            int ae = interval[1];
            int bs = newInterval[0];
            int be = newInterval[1];
            if((as<=bs && ae<=be && ae>=bs) || (as>=bs && ae<=be)
                    || (as>=bs && ae>=be && as<=be) || (as<=bs && ae>=be)) {
                startMerge = Math.min(startMerge, Math.min(as, bs));
                endMerge = Math.max(endMerge, Math.max(ae, be));
            } else if(endMerge < 0) {
                result.add(interval);
            } else {
                result.add(new int[] {startMerge, endMerge});
                endMerge = -2;
                result.add(interval);
            }
        }
        if(endMerge >= 0) {
            result.add(new int[] {startMerge, endMerge});
            return result.toArray(new int[0][]);
        }
        if(endMerge == -2) {
            return result.toArray(new int[0][]);
        }
        int[][] value = new int[result.size()+1][2];
        int j = 0;
        boolean isAdded = false;
        for(int i=0; i<intervals.length; i++) {
            if(!isAdded && newInterval[0] < intervals[i][0]) {
                value[j++] = newInterval;
                isAdded = true;
            }
            value[j++] = intervals[i];
        }
        if(!isAdded) {
            value[j] = newInterval;
        }
        return value;
    }
}
