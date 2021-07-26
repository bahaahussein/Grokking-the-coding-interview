package com.KWayMerge;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

medium
 */

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        int w = matrix[0].length;
        PriorityQueue<Item> pq = new PriorityQueue<>((x, y) -> matrix[x.i][x.j] - matrix[y.i][y.j]);
        for(int i=0; i<h; i++)
            pq.add(new Item(i, 0));
        for(int i=0; i<k-1; i++) {
            Item min = pq.remove();
            if(min.j+1<w)
                pq.add(new Item(min.i, min.j+1));
        }
        Item result = pq.remove();
        return matrix[result.i][result.j];
    }
}

class Item {
    int i;
    int j;

    Item(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
