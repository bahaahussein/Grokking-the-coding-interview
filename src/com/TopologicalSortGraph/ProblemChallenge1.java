package com.TopologicalSortGraph;

import java.util.*;

public class ProblemChallenge1 {

    public boolean canConstruct(int[] originalSequence, int[][] sequences) {
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int seq : originalSequence) {
            adjMap.put(seq, new HashSet<>());
            inDegree.put(seq, 0);
        }

        for(int[] seq : sequences) {
            for(int i=0; i<seq.length-1; i++) {
                adjMap.get(seq[i]).add(seq[i+1]);
                inDegree.put(seq[i+1], inDegree.get(seq[i+1]) + 1);
            }
        }

        Queue<Integer> source = new LinkedList<>();
        for(int seq : originalSequence) {
            if(inDegree.get(seq) == 0)
                source.add(seq);
        }

        int i = 0;

        while(!source.isEmpty()) {
            if(source.size() != 1)
                return false;
            int curr = source.remove();
            if(curr != originalSequence[i])
                return false;
            i++;
            for(int x : adjMap.get(curr)) {
                inDegree.put(x, inDegree.get(x) - 1);
                if (inDegree.get(x) == 0)
                    source.add(x);
            }
        }

        return i == originalSequence.length;
    }
}
