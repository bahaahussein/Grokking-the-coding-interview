package com.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueGeneralizedAbbreviations {

    public List<String> uniqueGeneralizedAbbreviations(String word) {
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder());
        for(int i=0; i<word.length(); i++) {
            for(int N = queue.size(); N>0; N--) {
                StringBuilder curr = queue.remove();
                queue.add(new StringBuilder(curr).append(word.charAt(i)));
                if(curr.length() > 0 && curr.charAt(curr.length()-1) >= '0' && curr.charAt(curr.length()-1) <= '9') {
                    int x = curr.charAt(curr.length()-1) - '0';
                    queue.add(curr.deleteCharAt(curr.length()-1).append(x+1));
                } else {
                    queue.add(curr.append('1'));
                }
            }
        }

        List<String> finalResult = new ArrayList<>();
        while(!queue.isEmpty()) {
            finalResult.add(queue.remove().toString());
        }
        return finalResult;
    }
}
