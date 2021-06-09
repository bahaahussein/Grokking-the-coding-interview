package com.fast.slow.pointers;

import com.ListNode;

public class ProblemChallenge2 {

    public void reorderList(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode h2 = reverse(s);
        while(head != h2 && h2.next != null) {
            ListNode temp = head.next;
            head.next = h2;
            ListNode temp2 = h2.next;
            h2.next = temp;
            head = temp;
            h2 = temp2;
        }
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
