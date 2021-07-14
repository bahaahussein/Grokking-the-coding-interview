package com.modifiedBinarySearch;

public class CeilingOfNumber {

    public int findCeil(int[] arr, int key) {
        if(key > arr[arr.length-1])
            return -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]<key) // right
                start = mid + 1;
            else // left
                end = mid - 1;
        }
        return start;
    }
}

