package leetcode;

import dataStructure.ListNode;

public class L24SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode n = new ListNode(0);
        n.next = head;
        ListNode cur = n;
        while(cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;
            n1.next = n2.next;
            n2.next = n1;
            cur.next = n2;
            cur = cur.next.next;
        }
        return n.next;
    }
}
