package com.TopKElements;

/*
https://leetcode.com/problems/reorganize-string/

medium
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public String reorganizeString(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Data> pq = new PriorityQueue<>((x, y) -> y.frequency - x.frequency);
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Data(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Data data = pq.remove();
        sb.append(data.c);
        data.frequency--;
        if(data.frequency>0)
            pq.add(data);
        while(!pq.isEmpty()) {
            Data first = pq.remove();
            if(first.c != sb.charAt(sb.length()-1)) {
                sb.append(first.c);
                first.frequency--;
                if(first.frequency>0)
                    pq.add(first);
            } else if(pq.isEmpty()) {
                return "";
            } else {
                Data second = pq.remove();
                pq.add(first);
                sb.append(second.c);
                second.frequency--;
                if(second.frequency>0)
                    pq.add(second);
            }
        }
        return sb.toString();
    }



    private static class Data {
        private char c;
        private int frequency;

        private Data(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }
}
