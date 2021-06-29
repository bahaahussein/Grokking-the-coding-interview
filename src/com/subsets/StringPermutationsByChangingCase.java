package com.subsets;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-case-permutation/

medium
 */

public class StringPermutationsByChangingCase {

    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> result = new ArrayList<>();
        result.add(new StringBuilder());
        for(int i=0; i<s.length(); i++) {
            List<Character> addChars = new ArrayList<>();
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                addChars.add(s.charAt(i));
            else {
                addChars.add(s.charAt(i));
                if(Character.isUpperCase(s.charAt(i)))
                    addChars.add(Character.toLowerCase(s.charAt(i)));
                else
                    addChars.add(Character.toUpperCase(s.charAt(i)));
            }
            List<StringBuilder> temp = new ArrayList<>();
            for(StringBuilder item : result) {
                for(char c : addChars) {
                    temp.add(new StringBuilder(item).append(c));
                }
            }
            result = temp;
        }
        List<String> permutations = new ArrayList<>();
        for(StringBuilder sb : result)
            permutations.add(sb.toString());
        return permutations;
    }
}
