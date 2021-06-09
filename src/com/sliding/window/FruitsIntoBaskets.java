package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    public int totalFruit(int[] tree) {
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int end=0; end<tree.length; end++) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            while(map.size() > 2) {
                map.put(tree[start], map.get(tree[start]) - 1);
                if(map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
