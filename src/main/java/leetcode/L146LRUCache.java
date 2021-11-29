package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L146LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    Node tail;
    Node head;
    int size;
    int maxSize = 0;
    Map<Integer, Node> map;

    public L146LRUCache(int capacity) {
        tail = new Node(-1, -1);
        head = new Node(-1, -1);
        tail.prev = head;
        head.next = tail;
        size = 0;
        maxSize = capacity;
        map = new HashMap();
    }

    public int get(int k) {
        if (map.containsKey(k)) {
            int v = map.get(k).val;
            remove(k);
            put(k, v);
            return v;
        } else {
            return -1;
        }
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            remove(k);
        }

        Node n = new Node(k, v);
        map.put(k, n);
        Node next = head.next;
        head.next = n;
        n.prev = head;
        n.next = next;
        next.prev = n;
        size++;
        if (size > maxSize) {
            Node last = tail.prev;
            remove(last.key);
        }
    }

    private void remove(int k) {
        if (!map.containsKey(k)) {
            return;
        }

        Node cur = map.get(k);
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
        map.remove(k);
        size--;

    }
}
