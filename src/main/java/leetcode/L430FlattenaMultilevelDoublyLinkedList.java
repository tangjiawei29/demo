package leetcode;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class L430FlattenaMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head) {
        Node last = null;
        Node cur = head;
        while(cur != null) {
            if (cur.child == null) {
                last = cur;
                cur = cur.next;
            } else {
                Node next = cur.next;
                Node childlast = dfs(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                if (next != null) {
                    childlast.next = next;
                    next.prev = childlast;
                }
                last = childlast;
                cur = next;
            }
        }
        return last;
    }

}
