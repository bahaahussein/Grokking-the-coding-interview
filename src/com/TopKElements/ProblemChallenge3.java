package com.TopKElements;

import java.util.*;

/*
https://leetcode.com/problems/maximum-frequency-stack/

hard
 */

public class ProblemChallenge3 {

    private int maxFreq;

    private Map<Integer, Integer> freqMap;

    private Map<Integer, Stack<Integer>> stackMap;

    public ProblemChallenge3() {
        maxFreq = 0;
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
    }

    public void push(int val) {
        int f = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, f);
        stackMap.computeIfAbsent(f, x -> new Stack<>()).push(val);
        if(f > maxFreq)
            maxFreq = f;
    }

    public int pop() {
        Stack<Integer> stack = stackMap.get(maxFreq);
        int result = stack.pop();
        if(stack.isEmpty())
            maxFreq--;
        freqMap.put(result, freqMap.get(result) - 1);
        return result;
    }
}
