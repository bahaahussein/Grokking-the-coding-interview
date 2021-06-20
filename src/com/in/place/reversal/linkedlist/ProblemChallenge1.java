package com.in.place.reversal.linkedlist;

import com.ListNode;

/*
https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/

medium
 */

public class ProblemChallenge1 {

    public ListNode kAlternateReverse(ListNode head, int k) {

        boolean isReverse = false;
        ListNode curr = head;
        int i = 0;
        ListNode prev = null;
        ListNode x = null;
        ListNode y = null;
        ListNode newHead = null;

        while(curr != null) {
            if(i % k == 0) {
                if(isReverse) {
                    if(x != null) {
                        x.next = prev;
                    } else {
                        newHead = prev;
                    }
                    y.next = curr;
                    isReverse = false;
                } else {
                    x = prev;
                    y = curr;
                    isReverse = true;
                }
            }

            if(isReverse) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }

            i++;

        }

        if(isReverse) {
            if(x != null) {
                x.next = prev;
            } else {
                newHead = prev;
            }
            y.next = curr;
        }

        return newHead;

    }
}
