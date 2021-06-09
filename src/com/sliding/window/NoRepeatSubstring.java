package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, end);
            result = Math.max(result, end-start+1);
        }
        return result;
    }
}
