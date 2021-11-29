package leetcode;

import dataStructure.ListNode;

public class L725SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode tmp = head;
        while(tmp != null) {
            n++;
            tmp = tmp.next;
        }
        int size = n / k;
        int extra = n % k;
        ListNode[] arr = new ListNode[k];
        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while(cur != null) {
            arr[i] = head;
            for (int j = 0; j < size; j++) {
                pre = cur;
                cur = cur.next;
            }
            if (extra > 0) {
                pre = cur;
                cur = cur.next;
                extra--;
            }

            pre.next = null;
            head = cur;
            i++;
        }
        while(i < k && i < size - 1) {
            arr[i++] = null;
        }

        return arr;
    }
}
