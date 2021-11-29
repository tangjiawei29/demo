package leetcode;

import dataStructure.ListNode;

import java.util.Random;

public class L382LinkedListRandomNode {
    ListNode head = null;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public L382LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int res = head.val;
        ListNode cur = head.next;
        int cnt = 1;
        Random ran = new Random();
        while(cur != null) {

            if (ran.nextInt(++cnt) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
