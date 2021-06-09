package com.fast.slow.pointers;

/*
https://leetcode.com/problems/palindrome-linked-list/

easy in leetcode (medium)
 */

import com.ListNode;

public class ProblemChallenge1 {

    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode h2 = reverse(s);
        while(h2!=null) {
            if(head.val != h2.val)
                return false;
            h2=h2.next;
            head=head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }
        return prev;
    }
}
