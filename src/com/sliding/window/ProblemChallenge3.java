package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/

difficulty: hard
 */


public class ProblemChallenge3 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        int distinct = 0;
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            int curr = tMap.getOrDefault(c, 0);
            if(curr == 0)
                distinct++;
            tMap.put(c, curr + 1);
        }

        int l = 0;
        int r = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        int[] ans = new int[] {-1, 0, 0};

        while(r<s.length()) {
            char c = s.charAt(r);
            if(tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if(sMap.get(c).intValue() == tMap.get(c).intValue())
                    distinct--;
                while(distinct==0 && l<=r) {
                    char cc = s.charAt(l);
                    if(tMap.containsKey(cc) && sMap.get(cc).intValue() == tMap.get(cc).intValue()) {
                        distinct++;
                        if(ans[0]==-1 || r-l+1<ans[0]) {
                            ans[0] = r-l+1;
                            ans[1] = l;
                            ans[2] = r;
                        }
                    }
                    sMap.put(cc, sMap.getOrDefault(cc, 0) - 1);
                    l++;
                }
            }
            r++;
        }

        return ans[0] == -1? "" : s.substring(ans[1], ans[2] + 1);
    }
}
