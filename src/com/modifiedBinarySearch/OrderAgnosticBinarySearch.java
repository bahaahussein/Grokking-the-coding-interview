package com.modifiedBinarySearch;

public class OrderAgnosticBinarySearch {

    public int findKey(int[] arr, int key) {
        int N = arr.length;
        if(arr[0] == arr[N-1]) {
            return -1;
        } else if(arr[0] > arr[N-1]) { // descending ex 10, 8, 3, 1
            int start = 0;
            int end = N-1;
            while(start<=end) {
                int mid = start + (end-start)/2;
                if(arr[mid] == key)
                    return mid;
                else if(arr[mid]>key) // right
                    start = mid + 1;
                else // left
                    end = mid - 1;
            }
            return -1;
        } else { // ascending ex 1, 3, 8, 10
            int start = 0;
            int end = N-1;
            while(start<=end) {
                int mid = start + (end-start)/2;
                if(arr[mid] == key)
                    return mid;
                else if(arr[mid]<key) // right
                    start = mid + 1;
                else // left
                    end = mid - 1;
            }
            return -1;
        }
    }
}
