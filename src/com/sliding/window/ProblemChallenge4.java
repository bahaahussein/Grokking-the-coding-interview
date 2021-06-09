package com.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/

hard
 */


public class ProblemChallenge4 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();


        for(int i=0; i<=s.length()-(wordLength*words.length); i++) {
            Map<String, Integer> seenMap = new HashMap<>();
            boolean isValid = true;
            for(int j=0; j<words.length; j++) {
                int start = i+(j*wordLength);
                int end = i+((j+1)*wordLength);
                String curr = s.substring(start, end);
                if(!wordsMap.containsKey(curr)) {
                    isValid = false;
                    break;
                }
                seenMap.put(curr, seenMap.getOrDefault(curr, 0) + 1);
                if(seenMap.get(curr) > wordsMap.get(curr)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                result.add(i);
            }
        }

        return result;
    }
}
