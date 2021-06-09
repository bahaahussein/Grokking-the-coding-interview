package com.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringKDistinct {

    public int findLength(final String str, final int k) {
        if (k == 0 || str == null || str.length() == 0) {
            return 0;
        }
        final List<Integer> changed = new ArrayList<>();
        final Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k) {
                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
                if(map.get(str.charAt(j)) == 0) {
                    map.remove(str.charAt(j));
                }
                j++;
            }
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
