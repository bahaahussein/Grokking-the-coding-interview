package com.sliding.window;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/


public class ProblemChallenge2 {

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return new ArrayList<Integer>();
        }
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for(int i=0; i<p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(pArr[i] == sArr[i])
                count++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length() - p.length(); i++) {
            if(count==26)
                result.add(i);

            if(sArr[s.charAt(i) - 'a'] == pArr[s.charAt(i) - 'a'])
                count--;
            else if(sArr[s.charAt(i) - 'a'] == pArr[s.charAt(i) - 'a'] + 1)
                count++;
            sArr[s.charAt(i) - 'a']--;

            if(sArr[s.charAt(i + p.length()) - 'a'] == pArr[s.charAt(i + p.length()) - 'a'])
                count--;
            else if(sArr[s.charAt(i + p.length()) - 'a'] == pArr[s.charAt(i + p.length()) - 'a'] - 1)
                count++;
            sArr[s.charAt(i + p.length()) - 'a']++;
        }
        if(count == 26)
            result.add(s.length() - p.length());

        return result;
    }
}
