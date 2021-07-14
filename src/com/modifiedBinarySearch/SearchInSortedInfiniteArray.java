package com.modifiedBinarySearch;

import com.ArrayReader;

public class SearchInSortedInfiniteArray {

    public int findKey(ArrayReader arr, int key) {
        int start = 0;
        int end = 1;
        if(key < arr.get(0))
            return -1;
        while(arr.get(end) < key) {
            int oldEnd = end;
            end = (end-start+1)*2;
            start = oldEnd+1;
        }
        if(arr.get(end) == key)
            return end;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr.get(mid) == key)
                return mid;
            else if(arr.get(mid)<key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}


