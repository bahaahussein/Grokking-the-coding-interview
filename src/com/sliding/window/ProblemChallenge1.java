package com.sliding.window;

/*

https://leetcode.com/problems/permutation-in-string/

        Given two strings s1 and s2, return true if s2 contains the permutation of s1.

        In other words, one of s1's permutations is the substring of s2.



        Example 1:

        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").
        Example 2:

        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false


        Constraints:

        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemChallenge1 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int start = 0;
        for(int end=0; end<s2.length(); end++) {
            char c = s2.charAt(end);
            if(!map.containsKey(c)) {
                while(start<end) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    start++;
                }
                start++;
            } else if(map.get(c) == 0) {
                while(s2.charAt(start) != c) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    start++;
                }
                start++;
            } else {
                map.put(c, map.get(c) - 1);
                if(end-start+1 == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
