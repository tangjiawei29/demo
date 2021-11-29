package leetcode;

import java.util.HashMap;

public class L684RedundantConnection {
    class Node {
        int v;
        Node parent;
        int rank;
    }

    Node makeset(int v) {
        Node n = new Node();
        n.v = v;
        n.parent = n;
        n.rank = 1;
        return n;
    }

    Node find(Node n) {
        while(n.parent != n) {
            n = n.parent;
        }
        return n;
    }

    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Node> map = new HashMap();
        for (int i = 1; i <= edges.length; i++) {
            map.putIfAbsent(i, makeset(i));
        }
        int[] pair = null;
        for (int[] p : edges) {
            Node p1 = find(map.get(p[0]));
            Node p2 = find(map.get(p[1]));
            if (p1 == p2) {
                pair = p;
            }
            if (p1.rank > p2.rank)
                p2.parent = p1;
            else {
                p1.parent = p2;
                if (p1.rank == p2.rank)
                    p2.rank++;
            }
        }
        return pair;
    }
}
