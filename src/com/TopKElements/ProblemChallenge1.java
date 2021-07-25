package com.TopKElements;

import java.util.*;

public class ProblemChallenge1 {

    public String reorganizeString(String s, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> frequencyMap.get(y) - frequencyMap.get(x));
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
            pq.add(entry.getKey());
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        while(!pq.isEmpty()) {
            char c = pq.remove();
            sb.append(c);
            int frequency = frequencyMap.get(c);
            frequency--;
            frequencyMap.put(c, frequency);
            if(frequency >= 0)
                q.add(c);
            while(q.size() == k) {
                char cc = q.remove();
                int frequencyy = frequencyMap.get(cc);
                if(frequencyy != 0) {
                    sb.append(cc);
                    frequencyy--;
                    frequencyMap.put(cc, frequencyy);
                    q.add(c);
                }
            }
        }
        return sb.length() == s.length()? sb.toString() : "";
    }
}
