package leetcode;

import dataStructure.ListNode;

public class L61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        ListNode end = node;
        while(node != null) {
            len++;
            end = node;
            node = node.next;
        }
        if (len == 0 || k % len == 0) return head;
        while(k > len) {
            k %= len;
        }
        ListNode zeroNode = new ListNode(0);
        ListNode newEndNode = head;
        for (int i = 1; i <= len; i++) {
            if (len - k == i) {
                break;
            }
            newEndNode = newEndNode.next;
        }
        zeroNode.next = newEndNode.next;
        newEndNode.next = null;
        end.next = head;
        return zeroNode.next;
    }
}
